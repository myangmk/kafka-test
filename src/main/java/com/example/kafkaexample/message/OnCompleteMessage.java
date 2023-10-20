package com.example.kafkaexample.message;


public record OnCompleteMessage(
        String title,
        String someMessage
) {
}
