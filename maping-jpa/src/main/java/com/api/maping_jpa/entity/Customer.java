package com.api.maping_jpa.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Table
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long customerId;

    @NotBlank(message = "mandatory name")
    private String name;

    @NotBlank(message = "email required please")
    @Email(message = "enter the valid email")
    private String email;

    private String gender;

    @NotBlank(message = "phone number is mandatory")
    @Pattern(regexp = "^(072|073|078|079)\\d{7}$",
            message = " message = \"phone must start with 072, 073, 078, or 079 followed by 7 digits\")")
    private String phoneNumber;

    @NotBlank(message = "address require please")
    private String address;

    @OneToMany(targetEntity = Product.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "cp_fk", referencedColumnName = "customerId")
    private List<Product> products;

}
