package com.ecommerce.RabbitMQ;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;
import com.ecommerce.entity.Bestellung;

@Component
public class producerVonBestellung {

    private final RabbitTemplate rabbitTemplate;

    public static final String EXCHANGE_NAME = RabbitMQConfig.EXCHANGE_NAME;
    public static final String ROUTING_KEY = RabbitMQConfig.ROUTING_KEY;

    public producerVonBestellung(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendOrderToCrm(Bestellung bestellung) {
        rabbitTemplate.convertAndSend(EXCHANGE_NAME, ROUTING_KEY, bestellung);
        System.out.println("CRM Message sent: " + bestellung.getOrderID());
    }
}
