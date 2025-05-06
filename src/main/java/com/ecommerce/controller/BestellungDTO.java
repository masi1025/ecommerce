package com.ecommerce.controller;

import com.ecommerce.entity.LieferstatusType;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;


@SuppressWarnings("RecordComponentNumber")
record BestellungDTO(

    @NotNull 
    String orderID,

    @NotNull   
    String customerID,

    String eMail,
    String productID,
    int quantity,
    String address,
    LocalDate orderDate,
    LieferstatusType deliveryStatus,
    LocalDate deliveryDate,
    String paymentMethod



    
) {
    
    interface OnCreate { }
}

