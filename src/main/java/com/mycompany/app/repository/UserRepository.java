package com.mycompany.app.repository;

import com.mycompany.app.entity.UserRecord;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserRecord, Long> {
  UserRecord findById(long id);
}
