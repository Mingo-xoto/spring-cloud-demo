package com.yhq.config;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "queue1")
public class Receiver {

    /**
     * 控制台非指定消息接收类全限定名
     * @param msg
     */
    @RabbitListener(queues = "hello", containerFactory="rabbitListenerContainerFactory")
    public void processWithBytes(byte[] msg) {
        System.out.println("==消费消息->>>>>"+new String(msg));
    }

    /**
     * 控制台指定消息接收类全限定名
     * @param msg
     */
    @RabbitListener(queues = "queue1", containerFactory="rabbitListenerContainerFactory")
    public void processWithString(@Payload String msg) {
        System.out.println("--消费消息->>>>>"+msg);
    }

}