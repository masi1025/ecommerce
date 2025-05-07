package com.ecommerce.controller;

import com.ecommerce.entity.Bestellung;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-07T11:32:18+0200",
    comments = "version: 1.6.3, compiler: Eclipse JDT (IDE) 3.42.0.z20250331-1358, environment: Java 21.0.6 (Eclipse Adoptium)"
)
@Component
class BestellungMapperImpl implements BestellungMapper {

    @Override
    public Bestellung ToBestellung(BestellungDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Bestellung bestellung = new Bestellung();

        bestellung.setOrderID( dto.orderID() );
        bestellung.setEMail( dto.eMail() );
        bestellung.setCustomerID( dto.customerID() );
        bestellung.setAddress( dto.address() );
        bestellung.setProductID( dto.productID() );
        bestellung.setQuantity( dto.quantity() );
        bestellung.setOrderDate( dto.orderDate() );
        bestellung.setDeliveryDate( dto.deliveryDate() );
        bestellung.setDeliveryStatus( dto.deliveryStatus() );
        bestellung.setPaymentMethod( dto.paymentMethod() );

        return bestellung;
    }
}
