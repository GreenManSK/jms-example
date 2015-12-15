# JMS Example

First, install ActiveMQ. If you work on student machines, follow the guide in a separate text file named activemq-install.md.

##Task 01

Run git clone https://github.com/misostc/jms-example.git

Run git checkout -f step1

Your task is to implement according to the TODOs a Producer based on Activemq which will sent a simple message. There is already an application skeleton containing an implementation of a Consumer which can receive this message and print it to System.out.

##Task02
Run git checkout -f step2

You will find solution to task01 there. Your task is to rewrite the current solution to use JNDI. 

1.	Write jndi.properties (found in /resources)
2.	Continue according to the TODOs found in /src

You can run git checkout –f step3 to see if your solution was right.

## Task03
Run git checkout –f step4

There is an implementation of a publisher which sends different messages to different topics. 
Look to the implementation of Publisher to see which two Topics are used. 
Your task is to create 2 Subscribers for each of them. Use Spring to create the subscribers. 

You can run git checkout –f step5 to see if your solution was right.

Merry Christmas and happy new year!






