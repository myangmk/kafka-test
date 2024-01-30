package com.example.kafkaexample.message;

import com.example.kafkaexample.repository.Bar;
import com.example.kafkaexample.repository.BarRepository;
import org.springframework.stereotype.Service;

@Service
class BarService {

    private final BarRepository barRepository;

    public BarService(BarRepository barRepository) {
        this.barRepository = barRepository;
    }

    public String getBar() {
        var bar = new Bar();
        barRepository.save(bar);
        System.out.println("bar = " + bar);
        return "bar";
    }

}
