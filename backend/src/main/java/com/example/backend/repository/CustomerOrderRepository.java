package com.example.backend.repository;

import com.example.backend.model.CustomerOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerOrderRepository extends JpaRepository<CustomerOrder, Integer> {

    @Query("select c from CustomerOrder c")
    List<CustomerOrder> get();
}
