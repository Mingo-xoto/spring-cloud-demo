package com.yhq.config;

import com.alibaba.fastjson.JSONObject;
import com.yhq.msg.MessageDto;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;

public class Receiver<T> {

//    /**
//     * 控制台非指定消息接收类全限定名
//     * @param msg
//     */
//    @RabbitListener(queues = "hello", containerFactory="rabbitListenerContainerFactory")
//    public void processWithBytes(byte[] msg) {
//        System.out.println("==消费消息->>>>>"+new String(msg));
//    }

    /**
     * 控制台非指定消息接收类全限定名
     * @param msg
     */
    @RabbitListener(queues = "hello", containerFactory="rabbitListenerContainerFactory")
    public <T> void processMessage(MessageDto<T> msg) {
        System.out.println("==hello队列消费消息->>>>>"+JSONObject.toJSONString(msg));
    }
/*
    */
/**
     * 控制台非指定消息接收类全限定名
     * @param msg
     *//*

    @RabbitListener(queues = "hello", containerFactory="rabbitListenerContainerFactory")
    public void processMessage(Message msg) {
        System.out.println("==消费消息->>>>>"+new String(msg.getBody()));
    }
*/

    /**
     * 控制台指定消息接收类全限定名
     * @param msg
     */
    @RabbitListener(queues = "queue1", containerFactory="rabbitListenerContainerFactory")
    public void processWithString(@Payload String msg, Message msg2) {
        System.out.println(new String(msg2.getBody()));
        System.out.println("--消费消息->>>>>"+msg);
    }

}