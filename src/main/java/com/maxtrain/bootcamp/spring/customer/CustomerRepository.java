package com.maxtrain.bootcamp.spring.customer;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;


public interface CustomerRepository extends CrudRepository<Customer, Integer>{
	Optional<Customer> findCustomerById(int id);
	Optional<Customer> findCustomerByCardCode(int cardCode);
}
