package com.example.kafkaexample.message;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.listener.AcknowledgingMessageListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

@Component
@Slf4j
class KafkaOnCompleteConsumer implements AcknowledgingMessageListener<String, String> {

    @Override
    @KafkaListener(topics = "newnew", containerFactory = "kafkaListenerContainerFactory")
    public void onMessage(ConsumerRecord<String, String> data, Acknowledgment acknowledgment) {
        acknowledgment.acknowledge();
        try {
            log.info("sleep start:" +  data.value());
            Thread.sleep(1000 * 30);
            log.info("sleep end: {}", data.value());
        } catch (Exception e) {
            log.error("Failed consuming message: ", e);
            throw new RuntimeException(e);
        }
    }
}
