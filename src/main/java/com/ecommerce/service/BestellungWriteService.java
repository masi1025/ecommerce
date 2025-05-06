package com.ecommerce.service;

import com.ecommerce.entity.Bestellung;
import com.ecommerce.entity.LieferstatusType;
import com.ecommerce.repository.BestellungRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class BestellungWriteService {

    private static final Logger LOGGER = LoggerFactory.getLogger(BestellungWriteService.class);

    private final BestellungRepository repo;

    
    
    BestellungWriteService(final BestellungRepository repo) {
        this.repo = repo;
    }

    public Bestellung create(final Bestellung bestellung) {
        LOGGER.debug("create: {}", bestellung);

     
        final var BestellungDB = repo.create(bestellung);
        LOGGER.debug("create: {}", BestellungDB);
        return BestellungDB;
    }

    
   public void handleStatusUpdateFromErp(String orderId, LieferstatusType newStatus) {
        boolean updated = repo.updateStatus(orderId, newStatus);
        if (!updated) {
            throw new IllegalArgumentException("Order not found with ID: " + orderId);
        }
    }
    
}
