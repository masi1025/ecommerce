package com.ecommerce.repository;

import com.ecommerce.entity.Bestellung;
import com.ecommerce.entity.LieferstatusType;
import com.ecommerce.entity.Produkt;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.stereotype.Component;

@Component
public class DB {

    @SuppressWarnings("StaticCollection")
    public static final List<Bestellung> BESTELLUNGEN;

    private List<Produkt> produkte;

    // Statischer Block: Initialisierung der Mock-Daten
    static {
        BESTELLUNGEN = Stream.of(
            new Bestellung(
                "ORD123",
                "CUST456",
                "kunde@example.com",
                "Musterstraße 12, 12345 Berlin",
                "PROD789",
                3,
                LocalDate.of(2025, 4, 25),
                LieferstatusType.Processing,
                LocalDate.of(2025, 4, 30),
                "Kreditkarte"
            ),
            new Bestellung(
                "ORD124",
                "CUST457",
                "kunde2@example.com",
                "Beispielweg 99, 98765 Hamburg",
                "PROD001",
                1,
                LocalDate.of(2025, 4, 20),
                LieferstatusType.Shipped,
                LocalDate.of(2025, 4, 24),
                "PayPal"
            )
        ).collect(Collectors.toList());
    }

    // Konstruktor: Initialisierung der Produkte
    public DB() {
        produkte = Stream.of(
            new Produkt("PROD789", "Laptop", "Electronics", BigDecimal.valueOf(999.99), 10),
            new Produkt("PROD001", "Smartphone", "Electronics", BigDecimal.valueOf(499.99), 15),
            new Produkt("PROD999", "Beispielprodukt", "Office", BigDecimal.valueOf(49.99), 100)
        ).collect(Collectors.toList());

        System.out.println("DB erfolgreich initialisiert. Folgende Produkte sind verfügbar:");
        produkte.forEach(System.out::println);
    }

    public static Bestellung get(String bestellId) {
        return BESTELLUNGEN.stream()
            .filter(b -> b.getOrderID().equals(bestellId))
            .findFirst()
            .orElse(null);
    }

    public static void put(Bestellung updated) {
        for (int i = 0; i < BESTELLUNGEN.size(); i++) {
            if (BESTELLUNGEN.get(i).getOrderID().equals(updated.getOrderID())) {
                BESTELLUNGEN.set(i, updated);  // Bestellung aktualisieren
                return;
            }
        }
        BESTELLUNGEN.add(updated);  // Falls nicht vorhanden, neu hinzufügen
    }

    // Methode zum Abrufen eines Produkts per ID
    public Produkt getProduktById(String productId) {
        return produkte.stream()
            .filter(produkt -> produkt.getProductID().equals(productId))
            .findFirst()
            .orElse(null);
    }
}
