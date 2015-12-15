package cz.muni.fi.pa165.jmsexample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;


@Component
public class WorldReceiver {
    @Autowired
    ConfigurableApplicationContext context;

    
    @JmsListener(destination = "world-destination")
    public void receiveWorldMessage(String message) {
        System.out.println("Received <" + message + ">");
    }
}
