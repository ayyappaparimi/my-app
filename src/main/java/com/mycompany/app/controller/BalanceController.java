package com.mycompany.app.controller;

import com.mycompany.app.entity.UserRecord;
import com.mycompany.app.foundation.Balance;
import com.mycompany.app.repository.TransactionRepository;
import com.mycompany.app.repository.UserRepository;
import org.apache.catalina.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class BalanceController {

    private final UserRepository userRepository;

    public BalanceController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/balance")
    public Balance getBalance(@RequestParam long userId) {
        Optional<UserRecord> user = userRepository.findById(userId);

        if (user.isPresent()) {
            return new Balance(user.get().getBalance());
        }
        return new Balance(0);
    }
}
