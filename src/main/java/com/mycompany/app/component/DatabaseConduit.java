package com.mycompany.app.component;

import com.mycompany.app.entity.UserRecord;
import com.mycompany.app.repository.UserRepository;
import org.springframework.stereotype.Component;

@Component
public class DatabaseConduit {
  private final UserRepository userRepository;

  public DatabaseConduit(UserRepository userRepository) { 
    this.userRepository = userRepository;
  }

  public void save(UserRecord userRecord) {
    userRepository.save(userRecord);
  }
}
