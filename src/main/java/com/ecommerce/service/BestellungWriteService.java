package com.ecommerce.service;

import com.ecommerce.entity.Bestellung;
import com.ecommerce.entity.LieferstatusType;
import com.ecommerce.entity.Produkt;
import com.ecommerce.repository.BestellungRepository;
import com.ecommerce.repository.DB;
import com.ecommerce.RabbitMQ.producerVonBestellung;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BestellungWriteService {

    private static final Logger LOGGER = LoggerFactory.getLogger(BestellungWriteService.class);

    private final BestellungRepository repo;
    private final producerVonBestellung producer;

    @Autowired
    private DB db;

    BestellungWriteService(final BestellungRepository repo, final producerVonBestellung producer) {
        this.repo = repo;
        this.producer = producer;
    }

    public Bestellung create(final Bestellung bestellung) {
        LOGGER.debug("create: {}", bestellung);

        final var BestellungDB = repo.create(bestellung);
        LOGGER.debug("create: {}", BestellungDB);

        // Produkt direkt aus der Mock-Datenbank abrufen
        Produkt produkt = db.getProduktById(bestellung.getProductID());

        if (produkt == null) {
            throw new RuntimeException("Produkt mit der ID " + bestellung.getProductID() + " nicht gefunden!");
        }

        // Nachricht an CRM senden
        producer.sendOrderToCrm(bestellung, produkt);

        return BestellungDB;
    }

    // Die Methode, die im Listener aufgerufen wird, um den Status zu aktualisieren
    public void handleStatusUpdateFromErp(String orderId, LieferstatusType status) {
        LOGGER.debug("ERP-Status Update erhalten für Bestellung: {}", orderId);
    
        // Bestellung aus der Datenbank abrufen
        Bestellung bestellung = repo.findById(orderId);
    
        if (bestellung == null) {
            throw new RuntimeException("Bestellung mit der ID " + orderId + " nicht gefunden!");
        }
    
        // Status aktualisieren über das Repository
        repo.updateStatus(orderId, status);
    
        LOGGER.info("Status der Bestellung {} wurde auf {} aktualisiert", orderId, status);
    }
}
