package cz.muni.fi.pa165.jmsexample;

import javax.jms.*;
import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;


public class Main {

    private static final String url = ActiveMQConnection.DEFAULT_BROKER_URL;

    static class Consumer implements Runnable {

        @Override
        public void run() {
            try {
                //TODO: Obtain connectionFactory through JNDI
                ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
                Connection connection = connectionFactory.createConnection();
                connection.start();
                Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
                
                //TODO: Obtain destination through JNDI
                Destination destination = session.createQueue("TASK2.HELLOWORLDQUEUE");
                MessageConsumer consumer = session.createConsumer(destination);
                Message message = consumer.receive();

                if (message instanceof TextMessage) {
                    TextMessage textMessage = (TextMessage) message;
                    String text = textMessage.getText();
                    System.out.println("Received: " + text);
                }

                consumer.close();
                session.close();
                connection.close();

            } catch (JMSException ex) {
                System.err.println("Problem with JMS: " + ex);
            } 
        }

    }

    static class Producer implements Runnable {

        @Override
        public void run() {
            try {
                //TODO: Obtain connectionFactory through JNDI
                ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
                Connection connection = connectionFactory.createConnection();
                connection.start();
                Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
                
                //TODO: Obtain destination through JNDI
                Destination destination = session.createQueue("TASK2.HELLOWORLDQUEUE");
                MessageProducer producer = session.createProducer(destination);
                producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
                
                String text = "Hello world!";
                TextMessage message = session.createTextMessage(text);
                System.out.println("Sent message: " + message.getText());
                
                producer.send(message);
                
                connection.close();
                session.close();
                connection.close();
            } catch (JMSException ex) {
                System.err.println("Problem with JMS: " + ex);
            }
        }

    }

    public static void main(String[] args) {

        Thread t1 = new Thread(new Consumer());
        Thread t2 = new Thread(new Producer());

        t1.start();
        t2.start();
    }
}
