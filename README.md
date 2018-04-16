1. Download KAFKA from <a href="https://kafka.apache.org/downloads">here</a> and extract the file into your directory
2. Run Zookeeper with command **bin/zookeeper-server-start.sh config/zookeeper.properties**
3. Run Kafka with command **bin/kafka-server-start.sh config/server.properties**
4. Create your topic with command **bin/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic (your topic)**
5. Download project(Kafka Message Driven), and change the topic on **Sender.java** file and **Receiver.java** file into your topic and you can run the project as spring boot app


__Thank You__

/*comment from me*/
 apa salah ku ya lord..wkwkwk