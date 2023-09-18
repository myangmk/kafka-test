package com.example.kafkaexample.message;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class KafkaProduceServiceTest {

    @Autowired
    KafkaProduceService produceService;

    @Test
    void send() {
        produceService.publishResultTopic();
    }

}
