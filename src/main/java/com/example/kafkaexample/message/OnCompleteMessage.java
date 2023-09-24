package com.example.kafkaexample.message;


record OnCompleteMessage(
        String title,
        String someMessage
) {
}
