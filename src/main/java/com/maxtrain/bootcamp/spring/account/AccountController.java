package com.maxtrain.bootcamp.spring.account;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin
@RestController
@RequestMapping("/api/accounts")
public class AccountController {
	@Autowired
	private AccountRepository acctRepo;
	
	// ALL ACCOUNTS
	@GetMapping
	public ResponseEntity<Iterable<Account>> getAccounts() {
		Iterable<Account> acct = acctRepo.findAll();
		return new ResponseEntity<>(acct, HttpStatus.OK);
	}
	
	// GET BY ID
	@GetMapping("{id}")
	public ResponseEntity<Account> getAccount(@PathVariable int id) {
		if(id <= 0) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		Optional<Account> acct = acctRepo.findById(id);
		if(acct.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Account>(acct.get(), HttpStatus.OK);
	}
	
	// POST ACCOUNT
	@PostMapping
	public ResponseEntity<Account> postAccount(@RequestBody Account acct) {
		if(acct.getId() != 0) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		acctRepo.save(acct);
		return new ResponseEntity<Account>(acct, HttpStatus.CREATED);
	}
	
	// PUT ACCOUNT
	@SuppressWarnings("rawtypes")
	@PutMapping("{id}")
	public ResponseEntity putAccount(@RequestBody Account acct) {
		if(acct.getId() <= 0) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		acctRepo.save(acct);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	// DELETE ACCOUNT
		@SuppressWarnings("rawtypes")
		@DeleteMapping("{id}")
		public ResponseEntity DeleteCustomer(@PathVariable int id) {
			if(id <= 0) {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
			acctRepo.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	
}
