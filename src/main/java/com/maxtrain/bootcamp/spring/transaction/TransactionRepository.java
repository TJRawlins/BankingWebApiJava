package com.maxtrain.bootcamp.spring.transaction;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

public interface TransactionRepository extends CrudRepository<Transaction, Integer> {
	Optional<Transaction> findTransactionById(int id);
}
