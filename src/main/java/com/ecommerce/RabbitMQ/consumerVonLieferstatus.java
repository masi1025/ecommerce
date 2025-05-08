package com.ecommerce.RabbitMQ;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
//import com.ecommerce.RabbitMQ.DeliveryStatusMessage;
import com.ecommerce.service.BestellungWriteService;

@Component

public class consumerVonLieferstatus {
 
    private final BestellungWriteService orderService;

    public consumerVonLieferstatus(BestellungWriteService orderService) {
        this.orderService = orderService;
    }

    @RabbitListener(
      queues = RabbitConfig.QUEUE_NAME,
      containerFactory = "rabbitListenerContainerFactory" 
    )
    public void receiveStatusUpdate(DeliveryStatusMessage message) {
        System.out.println("Received ERP update for Order: " + message.getOrderId());
        orderService.handleStatusUpdateFromErp(
            message.getOrderId(), message.getStatus()
        );
    }

}
