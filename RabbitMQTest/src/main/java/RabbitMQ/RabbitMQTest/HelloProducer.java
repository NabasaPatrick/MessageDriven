package RabbitMQ.RabbitMQTest;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class HelloProducer {
	private final static String QUEUE_NAME = "hellos";
	
	
	
	public static void main(String[] args) throws IOException, TimeoutException
	{
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();	
		String exit = ":exit";
		String execute = "";
		while(!execute.equals(exit)){
			Scanner sc = new Scanner(System.in);
			execute = sc.nextLine();
			if(!execute.equals(exit)){
			channel.queueDeclare(QUEUE_NAME, false,false,false,null);
			String message = "Hello World!";
			channel.basicPublish("", QUEUE_NAME, null, execute.getBytes("UTF-8"));
			System.out.println("[x] kirim pesan '"+execute+"'");
			}
		}
		channel.close();
		connection.close();
		
	}
}
