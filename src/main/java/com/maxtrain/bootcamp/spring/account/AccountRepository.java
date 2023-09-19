package com.maxtrain.bootcamp.spring.account;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account, Integer> {
	Optional<Account> findAccountById(int id);
}
