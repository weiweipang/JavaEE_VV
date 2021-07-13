package com.vv.producer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

/**
 * 演示spring与activeMq整合
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext-producer.xml")
public class SpringProducer {
    //ptp模式
    @Autowired
    @Qualifier("jmsQueueTemplate")
    JmsTemplate jmsQueueTemplate;
    //topic模式
    @Autowired
    @Qualifier("jmsTopicTemplate")
    JmsTemplate jmsTopicTemplate;


    @Test
    public void springSentPtP(){
        //1.参数1：队列名称
        //2.MessageCreater接口
        jmsQueueTemplate.send("spring_queue", new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {

                return session.createTextMessage("spring p2p message");
            }
        });
    }
    @Test
    public void springSentTopic(){
        //1.参数1：主题名称
        //2.MessageCreater接口
        jmsTopicTemplate.send("spring_topic", new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {

                return session.createTextMessage("spring topic message");
            }
        });
    }
}
