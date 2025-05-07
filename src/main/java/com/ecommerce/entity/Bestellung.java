package com.ecommerce.entity;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
public class Bestellung{

       @SuppressWarnings("unused")
       private static final long serialVersionUID = 1L;// Wird für die Serialisierung benötigt

    private String orderID;
    private String customerID;
    private String eMail;
    private String productID;
    private int quantity;
    private String address;
    private LocalDate orderDate;
    private LieferstatusType deliveryStatus;
    private LocalDate deliveryDate;
    private String paymentMethod;

   public Bestellung (final String orderID, final String customerID,
                      final String eMail,final String address, final String productID,
                      final int quantity, final LocalDate orderDate,
                      final LieferstatusType deliveryStatus,
                      final LocalDate deliveryDate, final String paymentMethod){
    this.orderID = orderID;
    this.customerID = customerID;
    this.eMail = eMail;
    this.address = address;
    this.productID = productID;
    this.quantity = quantity;
    this.orderDate = orderDate;
    this.deliveryStatus = deliveryStatus;
    this.deliveryDate = deliveryDate;
    this.paymentMethod = paymentMethod;

   }

 public String getOrderID(){
        return orderID;
      }

 public void setOrderID(final String orderID){
        this.orderID = orderID;
    }

 public String getCustomerID(){
        return customerID;
      }

 public void setCustomerID(final String customerID){
        this.customerID = customerID;
    }

 public String getEMail(){
        return eMail;
      }

 public void setEMail(final String eMail){
        this.eMail = eMail;
    }

 public String getAddress(){
        return address;
      }

 public void setAddress(final String address){
        this.address = address;
    }

 public String getProductID(){
        return productID;
      }

 public void setProductID(final String productID){
        this.productID = productID;
    }

 public int getQuantity(){
        return quantity;
      }

 public void setQuantity (final int quantity){
        this.quantity = quantity;
    }

 public LocalDate getOrderDate(){
        return orderDate;
      }

 public void setOrderDate (final LocalDate orderDate){
        this.orderDate = orderDate;
    }
 
 public LocalDate getDeliveryDate(){
        return deliveryDate;
      }

 public void setDeliveryDate (final LocalDate deliveryDate){
        this.deliveryDate = deliveryDate;
    }

 public LieferstatusType getDeliveryStatus(){
        return deliveryStatus;
      }

 public void setDeliveryStatus (final LieferstatusType deliveryStatus){
        this.deliveryStatus = deliveryStatus;
    }

 public String getPaymentMethod(){
        return paymentMethod;
      }

 public void setPaymentMethod(final String paymentMethod){
        this.paymentMethod = paymentMethod;
    }


   @Override
    public final boolean equals(final Object other) {
        return other instanceof Bestellung bestellung && Objects.equals(orderID, bestellung.orderID);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(orderID);
    }

    @Override
    public String toString() {
        return "Bestellung{" +
            "OrderID=" + orderID +
            "CustomerID=" + customerID +
            ", EMail'" + eMail + '\'' +
            ", Address'" + address + '\'' +
            "productID '=" + productID + '\'' +
            ",Quantity'" + quantity + '\'' +
            ",OrderDate'" + orderDate + '\'' +
            ",DeliveryStatus'" + deliveryStatus + '\'' +
            ",DeliveryDate'" + deliveryDate + '\'' +
            ", PaymentMethod=" + paymentMethod +
            '}';
    }
    
}