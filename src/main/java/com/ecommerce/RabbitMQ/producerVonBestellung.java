package com.ecommerce.RabbitMQ;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;
import com.ecommerce.entity.Bestellung;

@Component
public class producerVonBestellung {

    private final RabbitTemplate rabbitTemplate;

    public producerVonBestellung(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendOrderToCrm(Bestellung bestellung) {
        rabbitTemplate.convertAndSend("ecommerce-to-crm-exchange", "crm.routing.key", bestellung);
        System.out.println("CRM Message sent: " + bestellung.getOrderID());
    }
}
