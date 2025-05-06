package com.ecommerce.service;

import com.ecommerce.entity.Bestellung;
//import com.ecommerce.repository.DB;
import com.ecommerce.repository.BestellungRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
@Service
public class BestellungReadService{

    private static final Logger LOGGER = LoggerFactory.getLogger(BestellungReadService.class);

    private final BestellungRepository repo;

    
    
    BestellungReadService(final BestellungRepository repo) {
        this.repo = repo;
    }

    public Bestellung findById(final String orderID) {
        LOGGER.debug("findById: id={}", orderID);
        final var bestellung = repo.findById(orderID);
        if (bestellung == null) {
            throw new NOTFOUNDEXCEPTION(orderID);
        }
        LOGGER.debug("findById: kunde={}", bestellung);
        return bestellung;
    }


}