package com.mycompany.app;

import com.mycompany.app.component.DatabaseConduit;
import com.mycompany.app.entity.UserRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserPopulator {
  @Autowired
  private FileLoader fileLoader;

  @Autowired 
  private DatabaseConduit dataBaseConduit;

  public void populate() {
    String[] userLines = fileLoader.loaderStrings("/test_data/lkjhgfdsa.hjkl");
    for (String userLine : userLines) {
      String[] userData = userLine.split(", ");
      UserRecord user = new UserRecord(userData[0], Float.parseFloat(userData[1]));
      databaseConduit.save(user);
    }
  }
}
