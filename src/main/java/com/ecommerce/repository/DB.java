package com.ecommerce.repository;

import com.ecommerce.entity.Bestellung;
import com.ecommerce.entity.LieferstatusType;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class DB {

    @SuppressWarnings("StaticCollection")
    public static final List<Bestellung> BESTELLUNGEN;

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
            

       
    
    
}
