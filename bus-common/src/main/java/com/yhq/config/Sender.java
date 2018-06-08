package com.yhq.config;

import com.yhq.msg.MessageDto;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mq/")
public class Sender {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    @RequestMapping("send")
    public void send() {
        MessageDto dto = new MessageDto();
        dto.setName("fuck you man !");
//        String msg = "hello rabbitmq:"+new Date();
//        System.out.println("Sender:"+msg);
        this.rabbitTemplate.convertAndSend("hello", dto);
    }
}