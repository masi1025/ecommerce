package com.ecommerce.entity;
import java.util.Objects;
import java.math.BigDecimal;


public class Produkt{
    private String productID;
    private String productName;
    private String category;
    private BigDecimal price;
    private int stockQuantity;
    public Produkt( final String productID, final String productName,
                    final String category, final BigDecimal price,
                    final int stockQuantity){

        this.productID = productID;
        this.productName = productName;
        this.category = category;
        this.price = price;
        this.stockQuantity = stockQuantity;
     }
      
    public String getProductID(){
        return productID;
      }

    public void setProductID(final String productID){
        this.productID = productID;
    }

    public String getProductName(){
        return productName;
      }

    public void setProductName(final String productName){
        this.productName = productName;
    }
    public String getCategory(){
        return category;
      }

    public void setCategory(final String category){
        this.category = category;
    }

    public BigDecimal getPrice(){
        return price;
      }


    public void setPrice(final BigDecimal price){
        this.price = price;
    }  

    public int getStockQuantity(){
        return stockQuantity;
      }

    public void setStockQuantity(final int stockQuantity){
        this.stockQuantity = stockQuantity;
    }
    
    @Override
    public final boolean equals(final Object other) {
        return other instanceof Produkt product && Objects.equals(productID, product.productID);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(productID);
    }

     @Override
    public String toString() {
        return "Product{" +
            "productID=" + productID +
            ", ProductName='" + productName + '\'' +
            ", category='" + category + '\'' +
            ", Price=" + price +
            ", StockQuantity=" + stockQuantity +
            '}';
    }

}
