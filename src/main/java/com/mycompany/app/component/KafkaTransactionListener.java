package com.mycompany.app.component;

import com.mycompany.app.foundation.Transaction;
import com.mycompany.app.service.TransactionService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaTransactionListener {
    private final TransactionService transactionService;

    public KafkaTransactionListener(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @KafkaListener(topics = "${general.kafka-topic}", groupId = "my-app")
    public void listen(Transaction transaction) {
       // System.out.println("Transaction Amount : "+transaction.getAmount());
        transactionService.processTransaction(transaction);
    }
}
