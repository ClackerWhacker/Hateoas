package com.example.hateoas.service;

import com.example.hateoas.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerService extends JpaRepository<Customer, Long> {
}
