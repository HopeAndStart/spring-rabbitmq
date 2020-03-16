package com.zsl.rabbitmq;

import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;

/**
 * @author zsl
 * @version 1.0.0
 * @date: 2020/3/16 15:07
 **/
@Service("rabbitMqConsumer")
public class RabbitMqConsumer {
    
    public void consumerMessage(byte[] message) throws UnsupportedEncodingException {
//        byte[] body = message.getBody();
        String messageString = new String(message,"UTF-8");
        System.out.println(messageString);
    }
    
}
