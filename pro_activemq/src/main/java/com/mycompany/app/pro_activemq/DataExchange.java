package com.mycompany.app.pro_activemq;

import java.util.ArrayList;
import java.util.List;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

/**
 * 
 * @author Arvin's PC
 *
 */
public class DataExchange {
	/**
	 * send data method
	 * @param data
	 */
	public void dataSend(String data){
		Connection conn;
		Session session = null;
		MessageProducer producer = null;
		String queueName;
		ConnectionManager manager = new ConnectionManager();
		conn = manager.getConnection();//get connection
		try {
			conn.start();
			
			
			queueName = manager.getQueue();
			
			session = conn.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);
			Destination destination = session.createQueue(queueName);
			
			producer = session.createProducer(destination);// create producer
			TextMessage message = session.createTextMessage(data);
			producer.send(message);
			session.commit();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			manager.closeConnection(conn, session, producer, null);
		}
	}
	
	
	public List<String> dataReceive(){
		List<String> resultList = new ArrayList<String>();
		final int TIMEOUT = 1000;
		Connection conn;
		Session session = null;
		MessageConsumer consumer = null;
		String queueName;
		
		ConnectionManager manager = new ConnectionManager();
		conn = manager.getConnection();
		try {
			
			conn.start();
			queueName = manager.getQueue();
			
			session = conn.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);
			Destination destination = session.createQueue(queueName);
			consumer = session.createConsumer(destination);
			
			Message imsg;
			while((imsg = consumer.receive(TIMEOUT)) != null){
				if(imsg != null && (imsg instanceof TextMessage)){
					TextMessage txtMsg = (TextMessage)imsg;
					resultList.add(txtMsg.getText());
				}
			}
			session.commit();
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			manager.closeConnection(conn, session, null, consumer);
		}
		return resultList;
	}
	
}
