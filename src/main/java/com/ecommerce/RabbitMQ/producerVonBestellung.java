package com.ecommerce.RabbitMQ;

import com.ecommerce.entity.Bestellung;
import com.ecommerce.entity.Produkt;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class producerVonBestellung {

    private static final String EXCHANGE_NAME = "ecommerce-to-crm-exchange";
    private static final String ROUTING_KEY = "crm.routing.key";

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendOrderToCrm(Bestellung bestellung, Produkt produkt) {
        try {
            BestellungMessage message = new BestellungMessage(
                bestellung.getOrderID(),
                bestellung.getOrderDate(),
                bestellung.getProductID(),
                bestellung.getQuantity(),
                bestellung.getCustomerID(),
                produkt.getPrice(),
                bestellung.getDeliveryStatus().getValue()
            );

            // JSON-Nachricht erzeugen
            rabbitTemplate.convertAndSend(EXCHANGE_NAME, ROUTING_KEY, message);

            System.out.println("Nachricht erfolgreich gesendet an RabbitMQ.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
