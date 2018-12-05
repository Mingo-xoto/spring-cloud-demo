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

    @Autowired
    private RabbitMqConfig rabbitMqConfig;

    @RequestMapping("send")
    public <T> void  send(@RequestBody MessageDto<T> dto) {
        this.rabbitTemplate.convertAndSend(rabbitMqConfig.fanoutQueue().getName(), dto);
    }

    @RequestMapping("send2")
    public <T> void  send() {
        MessageDto<T> dto = new MessageDto();
        dto.setAge(100);
        dto.setName("faker大魔王");
        dto.setSex("男");
        this.rabbitTemplate.convertAndSend(rabbitMqConfig.fanoutExchange().getName(),rabbitMqConfig.fanoutQueue().getName(), dto);
    }

    @RequestMapping("get/hello")
    public <T>MessageDto<T> getMsg() {
        MessageDto<T> message = (MessageDto)this.rabbitTemplate.receiveAndConvert(rabbitMqConfig.helloQueue().getName());
        return message;
    }

    @RequestMapping("send/hello")
    public <T> void sendMsg(@RequestBody MessageDto<T> dto) {
        this.rabbitTemplate.convertAndSend(rabbitMqConfig.helloQueue().getName(), dto);
    }
}