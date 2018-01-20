package com.jms;

import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;


public class JMSSimpleReceiver {

	public static void main(String[] args) throws JMSException {
		/*Connection connection = new ActiveMQConnectionFactory("tcp://localhost:61616").createConnection();
		connection.start();
		System.out.println("conn established");
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		Queue queue = session.createQueue("TRADE.Q");
		System.out.println("sess established");
		MessageConsumer receiver = session.createConsumer(queue);
		System.out.println(receiver);
		Message receive = receiver.receive();
		System.out.println(receive);
		TextMessage msg = (TextMessage)receive;
		System.out.println(msg);
		System.out.println(msg.getText());
		connection.close();*/
		
		Connection connection = new ActiveMQConnectionFactory("tcp://localhost:61616").createConnection();
		connection.start();
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		Queue queue = session.createQueue("TRADE.Q");
		
		MessageConsumer receiver = session.createConsumer(queue);
		TextMessage msg = (TextMessage)receiver.receive();
		System.out.println(msg.getText());
		connection.close();
		
	}	

}
