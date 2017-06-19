package Kafka.KafkaTests;

import java.util.Properties;
import java.util.Scanner;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;


public class ProducerTest {
	 public static void main(String[] args) {
		 Properties props = new Properties();
		 props.put("bootstrap.servers", "localhost:9092");
		 props.put("acks", "all");
		 props.put("retries", 0);
		 props.put("log.retention", 0.1);
		 props.put("batch.size", 16384);
		 props.put("linger.ms", 1);
		 props.put("buffer.memory", 33554432);
		 props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		 props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		 Producer<String, String> producer = null;
		 try{
			 producer = new KafkaProducer<String, String>(props);
			 int i = 0;
			 while(true){
				 i++;
				 Scanner sc = new Scanner(System.in);
				 String line = sc.nextLine();
				 String msg = line+" = message-ke " + i;
				 producer.send(new ProducerRecord<String, String>("HellosKafkaTopic", msg));
				 //System.out.println("Sent:"+msg);
			 }
		 }
		 catch(Exception e){
			 e.printStackTrace();
		 }finally{
			 producer.close();
		 }
	 }
}
