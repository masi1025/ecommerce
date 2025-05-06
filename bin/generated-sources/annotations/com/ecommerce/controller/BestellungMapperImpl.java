package com.ecommerce.controller;

import com.ecommerce.entity.Bestellung;
import com.ecommerce.entity.LieferstatusType;
import java.time.LocalDate;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-06T14:46:40+0200",
    comments = "version: 1.6.3, compiler: Eclipse JDT (IDE) 3.42.0.z20250331-1358, environment: Java 21.0.6 (Eclipse Adoptium)"
)
@Component
class BestellungMapperImpl implements BestellungMapper {

    @Override
    public Bestellung ToBestellung(BestellungDTO dto) {
        if ( dto == null ) {
            return null;
        }

        String orderID = null;
        String address = null;
        String customerID = null;
        LocalDate deliveryDate = null;
        LieferstatusType deliveryStatus = null;
        LocalDate orderDate = null;
        String paymentMethod = null;
        String productID = null;
        int quantity = 0;
        String eMail = null;

        orderID = dto.orderID();
        address = dto.address();
        customerID = dto.customerID();
        deliveryDate = dto.deliveryDate();
        deliveryStatus = dto.deliveryStatus();
        orderDate = dto.orderDate();
        paymentMethod = dto.paymentMethod();
        productID = dto.productID();
        quantity = dto.quantity();
        eMail = dto.eMail();

        Bestellung bestellung = new Bestellung( orderID, customerID, eMail, address, productID, quantity, orderDate, deliveryStatus, deliveryDate, paymentMethod );

        bestellung.setEMail( dto.eMail() );

        return bestellung;
    }
}
