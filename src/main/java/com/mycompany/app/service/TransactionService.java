package com.mycompany.app.service;

import com.mycompany.app.entity.TransactionRecord;
import com.mycompany.app.entity.UserRecord;
import com.mycompany.app.foundation.Transaction;
import com.mycompany.app.repository.TransactionRepository;
import com.mycompany.app.repository.UserRepository;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TransactionService {

    private final UserRepository userRepository;
    private final TransactionRepository transactionRepository;

    // Adding repository to constructor
    public TransactionService(UserRepository userRepository, TransactionRepository transactionRepository) {
        this.userRepository = userRepository;
        this.transactionRepository = transactionRepository;
    }

    // Method for validation and processing Transaction
    public void processTransaction(Transaction transaction) {
/*
        Optional<UserRecord> sender = userRepository.findById(transaction.getSenderId());
        Optional<UserRecord> recipient = userRepository.findById(transaction.getRecipientId());
        float transactionAmount = transaction.getAmount();
        if (sender==null || recipient==null) {
            return;
        } else if (transactionAmount>sender.get().getBalance()) {
            return;
        } else {
            //Updating Sender balance
            sender.get().setBalance(sender.get().getBalance()-transactionAmount);

            //Updating Recipient balance
            recipient.get().setBalance(recipient.get().getBalance()+transactionAmount);
        }
        //Saving Data
        userRepository.save(sender);
        userRepository.save(recipient);

        TransactionRecord record = new TransactionRecord(sender., recipient.getId(), amount);

        transactoinReposiotory.save(record);
        */

        float transactionAmount = transaction.getAmount();
        //finding userOpt
        Optional<UserRecord> senderOpt = userRepository.findById(transaction.getSenderId());
        Optional<UserRecord> recipientOpt = userRepository.findById(transaction.getRecipientId());

        // Validate user exist or not
        if (senderOpt.isEmpty() || recipientOpt.isEmpty()) {
            return;
        }
        //getting sender and recipient
        UserRecord sender = senderOpt.get();
        UserRecord recipient = recipientOpt.get();
        //Imp condition
        if (transactionAmount > sender.getBalance()) {
            return;
        }

        // Updating the Balance of sender and recipient
        sender.setBalance(sender.getBalance()-transactionAmount);
        recipient.setBalance(recipient.getBalance()+transactionAmount);

        //Saving info in DB
        userRepository.save(sender);
        userRepository.save(recipient);

        // Save transaction
        TransactionRecord record = new TransactionRecord(sender.getId(), recipient.getId(), transactionAmount);
        transactionRepository.save(record);
//        userRepository.findAll().forEach(user -> {
//            if (user.getName().equals("waldorf")) {
//                System.out.println("Waldorf balance = " + user.getBalance());
//            }
//        });
    }
}
