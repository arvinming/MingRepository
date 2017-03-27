package com.mycompany.app.pro_activemq;

import java.io.InputStream;
import java.util.Properties;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;

/**
 * ConnectionManager
 *
 */
public class ConnectionManager {
    
	private String url;
	private String queue;
	private String username;
	private String password;
	
	private final String URL = "url_key";
	private final String QUEUE = "queue_key";
	private final String USERNAME = "username_key";
	private final String PASSWORD = "password_key";
	private final String FILEPATH = "/connection.properties";
	
	/**
	 * init
	 * @return
	 */
	public Boolean init(){
		Properties properties = new Properties();
		InputStream inputStream = Object.class.getResourceAsStream(FILEPATH);
		if(inputStream != null){
			try {
				properties.load(inputStream);
				url = properties.getProperty(URL);
				queue = properties.getProperty(QUEUE);
				username = properties.getProperty(USERNAME);
				password = properties.getProperty(PASSWORD);
				inputStream.close();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return true;
		}
		return false;
	}
	
	/**
	 * get connection
	 */
	public Connection getConnection(){
		Connection connection = null;
		if(init()){
			ConnectionFactory factory = new ActiveMQConnectionFactory(url);
			try {
				connection = factory.createConnection(username, password);
			} catch (JMSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return connection;
	}
	
	/**
	 * close connection
	 */
	public void closeConnection(Connection conn,Session session, 
			MessageProducer producer,MessageConsumer consumer){
		try {
			if(producer != null) producer.close();
			if(consumer != null) consumer.close();
			if(session != null) session.close();
			if(conn != null) conn.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	/**
	 * get queue name
	 */
	public String getQueue(){
		init();
		return this.queue;
	}
	
	
}
