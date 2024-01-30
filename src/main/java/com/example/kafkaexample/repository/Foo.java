package com.example.kafkaexample.repository;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Foo {

    @Id
    private Long id;

    public Foo() {
        this.id = System.currentTimeMillis();
    }
}
