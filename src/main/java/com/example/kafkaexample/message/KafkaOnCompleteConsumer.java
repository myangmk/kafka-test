package com.example.kafkaexample.message;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.listener.AcknowledgingMessageListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

@Component
@Slf4j
class KafkaOnCompleteConsumer implements AcknowledgingMessageListener<String, OnCompleteMessage> {

    @Override
    @KafkaListener(topics = "result", containerFactory = "kafkaListenerContainerFactory")
    public void onMessage(ConsumerRecord<String, OnCompleteMessage> data, Acknowledgment acknowledgment) {
        acknowledgment.acknowledge();
        OnCompleteMessage message = data.value();
        log.info("Got a message!: {}", message);
        try {
            Thread.sleep(10000);
            log.info("result message: {}", message);
        } catch (Exception e) {
            log.error("Failed consuming message: ", e);
        }
    }
}
