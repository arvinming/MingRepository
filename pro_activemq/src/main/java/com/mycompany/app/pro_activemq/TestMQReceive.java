package com.mycompany.app.pro_activemq;

import java.util.List;

public class TestMQReceive {
	
	public static void main(String[] args) {
		try {
			DataExchange dataexchange = new DataExchange();
			List<String> resultList = dataexchange.dataReceive();
			for (String string : resultList) {
				System.out.println("result is : " + string.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
