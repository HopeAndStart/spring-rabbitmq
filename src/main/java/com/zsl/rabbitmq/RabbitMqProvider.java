package com.zsl.rabbitmq;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author zsl
 * @version 1.0.0
 * @date: 2020/3/16 14:36
 **/
@RestController
public class RabbitMqProvider {

    @Resource(name = "providerRabbitTemplate")
    private RabbitTemplate rabbitTemplate;
    
    @GetMapping ("/sendMessage/{message}")
    public String sendMessage(@PathVariable("message") String messageString){
        try {
            MessageProperties properties = new MessageProperties();
            Message message = new Message(messageString.getBytes(),properties);
            rabbitTemplate.convertAndSend("provider.exchange","email.provider",message);
        }catch (Exception e){
            e.printStackTrace();
            return "发送失败";
        }
        return "发送成功";
    }

}
