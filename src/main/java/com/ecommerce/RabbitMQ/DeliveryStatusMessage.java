package com.ecommerce.RabbitMQ;

import com.ecommerce.entity.LieferstatusType;;
public class DeliveryStatusMessage {
    private String orderId;
    private LieferstatusType status;

    public DeliveryStatusMessage() {}

    public DeliveryStatusMessage(String orderId, LieferstatusType status) {
        this.orderId = orderId;
        this.status = status;
    }

    // Getter & Setter
    public String getOrderId() { return orderId; }
    public void setOrderId(String orderId) { this.orderId = orderId; }

    public LieferstatusType getStatus() { return status; }
    public void setStatus(LieferstatusType status) { this.status = status; }
}
