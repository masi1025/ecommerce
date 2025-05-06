package com.ecommerce.service;
import java.io.Serial;
import org.jspecify.annotations.Nullable;

public final class NOTFOUNDEXCEPTION extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1101909572340666200L;

    /// Fehlerhafte ID
    @Nullable
    private final String orderID;


  
    NOTFOUNDEXCEPTION() {
        super("Keine Bestellung gefunden.");
        orderID = null;
    
    }

   
    NOTFOUNDEXCEPTION(final String orderID) {
        super("Kein Kunde mit der ID " + orderID + " gefunden.");
        this.orderID = orderID;
        
    }
    
}
