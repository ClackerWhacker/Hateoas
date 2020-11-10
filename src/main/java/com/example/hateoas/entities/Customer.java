package com.example.hateoas.entities;


import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

import javax.persistence.*;

@Entity
public class Customer extends RepresentationModel<Customer> {


    @Column
    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @Getter
    @Setter
    private String name;

    @Column
    @Getter
    @Setter
    private String job;

    @Column
    @Getter
    @Setter
    private Long age;

    public Customer(String name, String job, Long age) {
        this.name = name;
        this.job = job;
        this.age = age;
    }

    public Customer() {
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", job='" + job + '\'' +
                ", age=" + age +
                '}';
    }
}
