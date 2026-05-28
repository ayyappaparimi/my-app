package com.mycompany.app.repository;

import com.mycompany.app.entity.UserRecord;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface UserRepository extends CrudRepository<UserRecord, Long> {
  //UserRecord findById(long id);
}
