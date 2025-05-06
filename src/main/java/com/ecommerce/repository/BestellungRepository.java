package com.ecommerce.repository;

import com.ecommerce.entity.Bestellung;

import java.util.Objects;
import org.jspecify.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import com.ecommerce.entity.LieferstatusType;

@Repository
public class BestellungRepository{

    private static final Logger LOGGER = LoggerFactory.getLogger(BestellungRepository.class);

    /*private final DB db;

 
    BestellungRepository( DB db) {
        this.db = db;
        
    }*/


    @Nullable
    public Bestellung findById(final String orderID) {
        LOGGER.debug("findById: id={}", orderID);
        final var result = DB.BESTELLUNGEN.stream()
            .filter(bestellung -> Objects.equals(bestellung.getOrderID(), orderID))
            .findFirst()
            .orElse(null);
        LOGGER.debug("findById: result={}", result);
        return result;
    }

   /*private Collection<Bestellung> findAll() {
        return DB.BESTELLUNGEN;
    }*/

    public Bestellung create(final Bestellung bestellung) {
        LOGGER.debug("create: {}", bestellung);
        DB.BESTELLUNGEN.add(bestellung);
        LOGGER.debug("create: bestellung={}", bestellung);
        return bestellung;
    }

     public boolean updateStatus(String orderId,   LieferstatusType newStatus) {
        Bestellung order = findById(orderId);
        if (order != null) {
            order.setDeliveryStatus(newStatus);
            DB.BESTELLUNGEN.add(order);
            return true;
        }
        return false;
    } 

}