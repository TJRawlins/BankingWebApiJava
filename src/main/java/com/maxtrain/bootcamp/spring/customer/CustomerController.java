package com.maxtrain.bootcamp.spring.customer;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin
@RestController
@RequestMapping("/api/customers")
public class CustomerController {
	@Autowired
	private CustomerRepository custRepo;
	
	// LOGIN
	@GetMapping("{cardCode}/{pinCode}")
	public ResponseEntity<Customer> login(@PathVariable int cardCode, @PathVariable int pinCode) {
		if(cardCode <= 0) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		Optional<Customer> cust = custRepo.findCustomerByCardCode(cardCode);
		if(cust.get().getPinCode() != pinCode) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Customer>(cust.get(), HttpStatus.OK);
	}
	
	// ALL CUSTOMERS
	@GetMapping
	public ResponseEntity<Iterable<Customer>> getCustomers() {
		Iterable<Customer> cust = custRepo.findAll();
		return new ResponseEntity<>(cust, HttpStatus.OK);
	}
	
	// GET BY ID
	@GetMapping("{id}")
	public ResponseEntity<Customer> getCustomer(@PathVariable int id) {
		if(id <= 0) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		Optional<Customer> cust = custRepo.findById(id);
		if(cust.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Customer>(cust.get(), HttpStatus.OK);
	}
	
	// POST CUSTOMER
	@PostMapping
	public ResponseEntity<Customer> postCustomer(@RequestBody Customer cust) {
		if(cust.getId() != 0) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		custRepo.save(cust);
		return new ResponseEntity<Customer>(cust, HttpStatus.CREATED);
	}
	
	// PUT CUSTOMER
	@SuppressWarnings("rawtypes")
	@PutMapping("{id}")
	public ResponseEntity putCustomer(@RequestBody Customer cust) {
		if(cust.getId() <= 0) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		custRepo.save(cust);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	// DELETE Customer
		@SuppressWarnings("rawtypes")
		@DeleteMapping("{id}")
		public ResponseEntity DeleteCustomer(@PathVariable int id) {
			if(id <= 0) {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
			custRepo.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
}
