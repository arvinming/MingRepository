package com.mycompany.app.pro_activemq;

public class TestMQSend {
	
	public static void main(String[] args) {
		try {
			DataExchange dataexchange = new DataExchange();
			dataexchange.dataSend("FuxiaoTing   i love you so much");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
