![image](https://github.com/user-attachments/assets/ce8b3073-ff98-4cdf-b803-408128e6fd7b)
https://kafka.apache.org/quickstart

Project Required:

1. Java 17
2. SpringBoot
3. Download and extract ZooKeeper  [Latest version]
4. Download and extract Kafka [Latest version]

Enviroment Setup:

Changes require in below file:


Commands need to run:
1. Open a command prompt and navigate to the zookeeper directory
  **.\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties**

2. Open a command prompt and navigate to the kafka directory
  **.\bin\windows\kafka-server-start.bat .\config\server.properties**
   
3. Open a command prompt and navigate to the kafka directory
  **.\bin\windows\kafka-topics.bat --create --topic notification-topic --bootstrap-server localhost:9092 --partitions 1 --replication-factor 1**
   
4. Same command window
  **.\bin\windows\kafka-console-consumer.bat --topic notification-topic --from-beginning --bootstrap-server localhost:9092**

5. Test the below API URL:
  **localhost:8081/message-sending/How are You?**

  And the Result is:
  ![image](https://github.com/user-attachments/assets/6dde65e5-d721-4120-a6ec-8375c9e3646e)

  Consumer Result:
  ![image](https://github.com/user-attachments/assets/9dcab210-dcd7-4d99-a637-6a7b4a062202)


