package com.api.maping_jpa.controller;

import com.api.maping_jpa.dto.OrderResponse;
import com.api.maping_jpa.entity.Customer;
import com.api.maping_jpa.entity.Product;
import com.api.maping_jpa.repo.CustomerRepo;
import com.api.maping_jpa.repo.ProductRepo;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/oder")
@Validated
public class CustomerController {

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private ProductRepo productRepo;

    @PostMapping("/place-order")
    public ResponseEntity<Customer> placeOrders(@Valid @RequestBody Customer orderRequest){
        return new ResponseEntity<Customer>(customerRepo.save(orderRequest), HttpStatus.CREATED);
    }

    @GetMapping("/orders")
    public List<Customer> getAllOrder(){
        return customerRepo.findAll();
    }

    @GetMapping("/orders-name-productName")
    public List<OrderResponse> getInformJoin(){
        return customerRepo.getJoinInformation();
    }

    @GetMapping("/products")
    public List<Product> getAllProduct(){
        return productRepo.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Product> getProductById(@PathVariable Long id){
        return productRepo.findById(id);
    }




}
