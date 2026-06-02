package com.mycompany.app.component;

import com.mycompany.app.foundation.Transaction;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaTransactionListener {

    @KafkaListener(topics = "${general.kafka-topic}", groupId = "my-app")
    public void listen(Transaction transaction) {
        System.out.println("Transaction Amount : "+transaction.getAmount());
    }
}
