package com.vv;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootProcucerApplication.class)
public class SpringbootProducer {

    @Autowired
    private JmsMessagingTemplate template;

    @Test
    public void p2pSendMsg(){
        template.convertAndSend("springboot_queue","springboot_p2p_message");
    }
}
