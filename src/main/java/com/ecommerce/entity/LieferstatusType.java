package com.ecommerce.entity;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.stream.Stream;
public enum LieferstatusType{
    Shipped("S"),
    Delivered("D"),
    Processing("P");
    private  final String value;

    LieferstatusType(final String value ){
        this.value = value;
    }
    @JsonValue
    public String getValue() {
        return value;
    }
    
    @JsonCreator
    public static LieferstatusType of(final String value) {
        return Stream.of(values())
            .filter(deliveryStatus -> deliveryStatus.value.equalsIgnoreCase(value))
            .findFirst()
            .orElse(null);
    }
}