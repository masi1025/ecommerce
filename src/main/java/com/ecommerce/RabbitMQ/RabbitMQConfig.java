package com.ecommerce.RabbitMQ;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String QUEUE_NAME = "erp-to-ecommerce-queue";
    public static final String EXCHANGE_NAME = "ecommerce-to-crm-exchange";
    public static final String ROUTING_KEY = "crm.routing.key";

    @Bean
    public Queue erpToEcommerceQueue() {
        return new Queue(QUEUE_NAME, true); // true = durable
    }

    @Bean
    public TopicExchange ecommerceExchange() {
        return new TopicExchange(EXCHANGE_NAME);
    }

    @Bean
    public Binding binding(Queue erpToEcommerceQueue, TopicExchange ecommerceExchange) {
        return BindingBuilder.bind(erpToEcommerceQueue).to(ecommerceExchange).with(ROUTING_KEY);
    }
}