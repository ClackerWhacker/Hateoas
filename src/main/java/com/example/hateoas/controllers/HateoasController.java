package com.example.hateoas.controllers;


import com.example.hateoas.entities.Customer;
import com.example.hateoas.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class HateoasController {

    @Autowired
    private CustomerService customerService;

    @GetMapping(path = "/customers")
    public Collection<Customer> getCustomers(){
        return customerService.findAll();
    }

    @GetMapping(path = "/get/{id}")
    public Customer getCustomerById(@PathVariable Long id) {
        Optional<Customer> customer = customerService.findById(id);
        if (customer.isEmpty()){
            return null;
        }
        Customer customer1 = customer.get();

        customer1.add(linkTo(methodOn(HateoasController.class).getCustomerById(id)).withSelfRel());
        return customer1;
    }

    // linkTo and MethodOn are static methods that let u fake start / invocate the controller
    // withSelfRel creates a link instance
    @GetMapping(path = "/getLinks")
    public Customer getLinks(@RequestParam(value = "name", defaultValue = "Comrade") String name) {
        Customer customer = new Customer(name, "Engineer",99L);
        customer.add(linkTo(methodOn(HateoasController.class).getCustomerById(99L)).withSelfRel());
        customer.add(linkTo(methodOn(HateoasController.class).getCustomers()).withSelfRel());
        customer.add(linkTo(methodOn(HateoasController.class).getLinks(name)).withSelfRel());
        return customer;
    }

}
