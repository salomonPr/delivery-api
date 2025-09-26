package com.api.maping_jpa.repo;

import com.api.maping_jpa.dto.OrderResponse;
import com.api.maping_jpa.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepo extends JpaRepository<Customer, Long> {

    // here we are going to return name of customer and productName from customer
    @Query(" select new com.api.maping_jpa.dto.OrderResponse(c.name, p.productName) from Customer c JOIN c.products p")
    public List<OrderResponse> getJoinInformation();



}
