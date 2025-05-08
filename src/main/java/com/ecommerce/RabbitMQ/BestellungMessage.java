package com.ecommerce.RabbitMQ;

import java.math.BigDecimal;
import java.time.LocalDate;

public class BestellungMessage {

    private String orderID;
    private LocalDate orderDate;
    private String productID;
    private int quantity;
    private String customerID;
    private BigDecimal price;
    private String status;

    // Neuer Konstruktor mit Status
    public BestellungMessage(String orderID, LocalDate orderDate, String productID, int quantity,
                             String customerID, BigDecimal price, String status) {
        this.orderID = orderID;
        this.orderDate = orderDate;
        this.productID = productID;
        this.quantity = quantity;
        this.customerID = customerID;
        this.price = price;
        this.status = status;
    }

    public String getOrderID() {
        return orderID;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public String getProductID() {
        return productID;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getCustomerID() {
        return customerID;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getStatus() {
        return status;
    }
}
