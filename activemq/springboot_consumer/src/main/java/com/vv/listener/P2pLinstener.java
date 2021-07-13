package com.vv.listener;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;

/**
 * 消息监听器，既可以监听p2p模式消息，也可以监听topic模式消息
 *
 */
@Component
public class P2pLinstener {

    @JmsListener(destination = "springboot_queue")
    public void receiveMessage(Message message){
        if(message instanceof TextMessage){
            try {
                System.out.println(((TextMessage) message).getText());
            } catch (JMSException e) {
                e.printStackTrace();
            }

        }

    }

}
