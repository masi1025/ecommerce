package com.ecommerce.service;

import com.ecommerce.entity.Bestellung;
import com.ecommerce.entity.LieferstatusType;
import com.ecommerce.repository.BestellungRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.ecommerce.RabbitMQ.producerVonBestellung;

@Service
public class BestellungWriteService {

    private static final Logger LOGGER = LoggerFactory.getLogger(BestellungWriteService.class);

    private final BestellungRepository repo;
    
    private final producerVonBestellung producer;

    
    
    BestellungWriteService(final BestellungRepository repo, final producerVonBestellung producer) {
        this.repo = repo;
        this.producer = producer;
    }

    public Bestellung create(final Bestellung bestellung) {
        LOGGER.debug("create: {}", bestellung);

     
        final var BestellungDB = repo.create(bestellung);
        LOGGER.debug("create: {}", BestellungDB);
        producer.sendOrderToCrm(bestellung);
        return BestellungDB;
    
    }

    
   public void handleStatusUpdateFromErp(String orderId, LieferstatusType newStatus) {
        boolean updated = repo.updateStatus(orderId, newStatus);
        if (!updated) {
            throw new IllegalArgumentException("Order not found with ID: " + orderId);
        }
    }
    
}
