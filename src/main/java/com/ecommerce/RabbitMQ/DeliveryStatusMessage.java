package com.ecommerce.RabbitMQ;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.ecommerce.entity.LieferstatusType;
import com.fasterxml.jackson.annotation.JsonFormat;

public class DeliveryStatusMessage {

    private String orderID;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate orderDate;
    private String productID;
    private int quantity;
    private String customerID;
    private BigDecimal price;
    private LieferstatusType status;

    // Leerer Konstruktor für Jackson
    public DeliveryStatusMessage() {
    }

    // Konstruktor für Jackson
    public DeliveryStatusMessage(String orderID, LocalDate orderDate, String productID, int quantity, String customerID,
            BigDecimal price, LieferstatusType status) {
        this.orderID = orderID;
        this.orderDate = orderDate;
        this.productID = productID;
        this.quantity = quantity;
        this.customerID = customerID;
        this.price = price;
        this.status = status;
    }

    // Getter und Setter
    public String getOrderId() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public LieferstatusType getStatus() {
        return status;
    }

    public void setStatus(LieferstatusType status) {
        this.status = status;
    }
}
