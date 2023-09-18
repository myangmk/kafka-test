package com.example.kafkaexample.message;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Service
@Slf4j
@RequiredArgsConstructor
class KafkaProduceService {
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final NewTopic resultTopic;

    public String publishResultTopic() {
        String message = "publish message to my_topic_1 " + UUID.randomUUID();

        CompletableFuture<SendResult<String, String>> future = kafkaTemplate.send(resultTopic.name(), message);
        future.whenComplete((result, ex) -> {
            if (ex == null) {
                System.out.println("Sent message=[" + message +
                        "] with offset=[" + result.getRecordMetadata().offset() + "]");
            } else {
                System.out.println("Unable to send message=[" +
                        message + "] due to : " + ex.getMessage());
            }
        });
        return "published";
    }
}
