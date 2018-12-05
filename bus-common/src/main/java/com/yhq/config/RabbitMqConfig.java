package com.yhq.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.RabbitListenerContainerFactory;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class RabbitMqConfig {

    @Bean
    public Binding bindingQueue2Topic(Queue topicQueue, TopicExchange topicExchange){
        return BindingBuilder.bind(topicQueue).to(topicExchange).with("faker_topic");
    }

    @Bean
    public Binding bindingQueue2Direct(Queue directQueue, DirectExchange directExchange){
        return BindingBuilder.bind(directQueue).to(directExchange).with("faker_direct");
    }

    @Bean
    public Binding bindingQueue2Fanout(Queue fanoutQueue, FanoutExchange fanoutExchange){
        return BindingBuilder.bind(fanoutQueue).to(fanoutExchange);
    }

    @Bean
    public Binding bindingQueue2Headers(Queue headerQueue, HeadersExchange headersExchange){
        return BindingBuilder.bind(headerQueue).to(headersExchange).where("vip").exists();
    }

    @Bean
    public Queue helloQueue() {
        return new Queue("hello");
    }

    @Bean
    public Queue topicQueue() {
        Queue queue = new Queue("topicQueue");
        return queue;
    }
    @Bean
    public Queue fanoutQueue() {
        Queue queue = new Queue("fanoutQueue");
        return queue;
    }
    @Bean
    public Queue directQueue() {
        Queue queue = new Queue("directQueue");
        return queue;
    }

    @Bean
    public Queue headerQueue() {
        Queue queue = new Queue("headerQueue");
        return queue;
    }

    @Bean
    public FanoutExchange fanoutExchange(){
        return new FanoutExchange("yhq_fanout");
    }

    @Bean
    public TopicExchange topicExchange(){
        return new TopicExchange("yhq_topic");
    }

    @Bean
    public HeadersExchange headersExchange(){
        Map<String, Object> arguments = new HashMap<String, Object>();
        arguments.put("vip","faker");
        HeadersExchange headersExchange = new HeadersExchange("yhq_header",true,false,arguments);
        return headersExchange;
    }

    @Bean
    public DirectExchange directExchange(){
        return new DirectExchange("yhq_direct");
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate template = new RabbitTemplate(connectionFactory);
        template.setMessageConverter(new Jackson2JsonMessageConverter());
        return template;
    }

    @Bean
    public SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory(ConnectionFactory connectionFactory) {
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        factory.setMessageConverter(new Jackson2JsonMessageConverter());
        return factory;
    }

}
