package com.opus.budget.repository;

import com.opus.budget.model.Account;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends MongoRepository<Account, String> {

    List<Account> findByUserId(String userId);

    List<Account> findByUserIdAndActive(String userId, boolean active);

    List<Account> findByUserIdAndType(String userId, String type);
}
