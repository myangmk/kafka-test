package com.example.kafkaexample.repository;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Bar {

    @Id
    private Long id;

    public Bar() {
        this.id = System.currentTimeMillis();
    }
}
