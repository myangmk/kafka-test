package com.example.kafkaexample.message;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
class KafkaOnCompleteConsumer {
    // consuming하는데에 여러 방식이 있다: batch, record별, etc.

    @KafkaListener(topics = "result", containerFactory = "kafkaListenerContainerFactory")
    public void listenOnComplete(String message) {
        log.info("Got a message!: {}", message);
        System.out.println(message);
    }

}
