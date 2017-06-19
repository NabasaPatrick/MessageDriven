package RabbitMQ.RabbitMQTest;

import java.io.IOException;

import javax.swing.colorchooser.DefaultColorSelectionModel;

import com.rabbitmq.client.*;

public class HelloConsumer {
	private final static String QUEUE_NAME = "hellos";
	
	public static void main(String[] argv) throws Exception
	{
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();
		
		channel.queueDeclare(QUEUE_NAME, false,false,false,null);
		System.out.println("[x] Menunggu pesan dari producer....");
		
		Consumer consumer = new DefaultConsumer(channel){
			@Override
			public void handleDelivery(String consumerTag, Envelope envelope, com.rabbitmq.client.AMQP.BasicProperties properties, byte[] body) throws java.io.IOException {
				String message = new String(body, "UTF-8");
				System.out.println("[x] menerima pesan '"+message+"'");
				
			}
		};
		channel.basicConsume(QUEUE_NAME,true, consumer);
	}
}
