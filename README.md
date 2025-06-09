![image](https://github.com/user-attachments/assets/ce8b3073-ff98-4cdf-b803-408128e6fd7b)

https://kafka.apache.org/quickstart

Project Required:

1. Java 17
2. SpringBoot (dependency: _spring-boot-starter-web_ and _spring-kafka_) 
4. Download and extract ZooKeeper  [Latest version]
5. Download and extract Kafka [Latest version]

Enviroment Setup:

**ZooKeeper Installation**

1. Go to your ZooKeeper config directory. For me its C:\apache-zookeeper-3.8.4-bin\conf.
2. Rename file “zoo_sample.cfg” to “zoo.cfg”.
3. Open zoo.cfg in any text editor, like Notepad; I prefer Notepad++.
4. Find and edit dataDir=/tmp/zookeeper like below
   
   ![image](https://github.com/user-attachments/assets/7f39bbb0-8b49-48c4-a313-6b5368790e77)
   
5. Add an entry in the System Environment Variables as we did for Java.
6. Add ZOOKEEPER_HOME = C:\apache-zookeeper-3.8.4-bin to the System Variables.
7. Edit the System Variable named “Path” and add ;%ZOOKEEPER_HOME%\bin;
8. Open a command prompt and navigate to the apache-zookeeper-3.8.4-bin directory. Run the following command to start Zookeeper: _.\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties_

**Setting Up Kafka**

1. Go to your Kafka config directory. For me its C:\kafka\config.
2. Edit the file “server.properties”. Find and edit the line "log.dirs=/tmp/kafka-logs" to "log.dir= C:\kafka\kafka-logs".
3. Open another command prompt and navigate to the Kafka directory. Run the following command to start the Kafka server: _.\bin\windows\kafka-server-start.bat .\config\server.properties_

**Error faced while starting server:**

1. The input line is too long when starting kafka
   **Solution**: keep short length of the path and rename the 'kafka_2.13-4.0.0' folder to something small, like just 'kafka'.

Commands need to run:
1. Open a command prompt and navigate to the zookeeper directory.
  **.\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties**

2. Open a command prompt and navigate to the kafka directory.
  **.\bin\windows\kafka-server-start.bat .\config\server.properties**
   
3. Creating a Kafka Topic. Open a command prompt and navigate to the kafka directory.
  **.\bin\windows\kafka-topics.bat --create --topic _notification-topic_ --bootstrap-server localhost:9092 --partitions 1 --replication-factor 1**
   
4. Consuming Messages from a Kafka Topic. Run the following command to Same command window.
  **.\bin\windows\kafka-console-consumer.bat --topic _notification-topic_ --from-beginning --bootstrap-server localhost:9092**

5. Producing Messages to a Kafka Topic: Test the below API URL:
  **localhost:8081/message-sending/How are You?**

  And the Result is:
  ![image](https://github.com/user-attachments/assets/6dde65e5-d721-4120-a6ec-8375c9e3646e)

  Consumer Result:
  ![image](https://github.com/user-attachments/assets/9dcab210-dcd7-4d99-a637-6a7b4a062202)

**Key Features of Apache Kafka:**

**Scalability**: Kafka can handle large volumes of data with ease, making it suitable for both small and large-scale applications.

**Fault Tolerance**: Kafka replicates data across multiple brokers, ensuring high availability and fault tolerance.

**High Throughput**: Kafka can process millions of messages per second, making it ideal for real-time data processing.

**Durability**: Kafka persists messages on disk, ensuring data is never lost.


**Kafka Architecture:**
At a high level, Kafka consists of the following components:

**Producer**: Sends messages (data) to Kafka topics.

**Consumer**: Reads messages from Kafka topics.

**Broker**: A Kafka server that stores data and serves clients.

**Topic**: A logical channel to which producers send messages and consumers read them.

**Zookeeper**: Manages and coordinates Kafka brokers. It helps in leader election, managing configurations, and more.
