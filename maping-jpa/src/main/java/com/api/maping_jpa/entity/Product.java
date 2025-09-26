package com.api.maping_jpa.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Table
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;
    @NotNull(message = "enter product name!")
    private String productName;
    @NotNull(message = "must not be null ")
    @Positive(message = "positive number please")
    private double quantity;
    @NotNull(message = "price required ")
    @Positive(message = "price must be positive ")
    private double pricePerQuantity;
    private double totalPrice;

    @PrePersist
    @PreUpdate
    public void calculateTotalPrice(){
        this.totalPrice = this.pricePerQuantity*this.quantity;
    }

}
