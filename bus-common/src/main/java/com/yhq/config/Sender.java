package com.yhq.config;

import com.yhq.msg.MessageDto;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mq/")
public class Sender {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    @RequestMapping("send")
    public <T> void  send(@RequestBody MessageDto<T> dto) {
        this.rabbitTemplate.convertAndSend("hello", dto);
    }
}