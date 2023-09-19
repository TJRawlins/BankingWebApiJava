package com.maxtrain.bootcamp.spring.transaction;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin
@RestController
@RequestMapping("/api/transactions")
public class TransactionController {
	@Autowired
	private TransactionRepository transRepo;
	
	// ALL TRANSACTIONS
	@GetMapping
	public ResponseEntity<Iterable<Transaction>> getTransactions() {
		Iterable<Transaction> trans = transRepo.findAll();
		return new ResponseEntity<>(trans, HttpStatus.OK);
	}
	
	// GET BY ID
	@GetMapping("{id}")
	public ResponseEntity<Transaction> getTransaction(@PathVariable int id) {
		if(id <= 0) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		Optional<Transaction> trans = transRepo.findById(id);
		if(trans.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Transaction>(trans.get(), HttpStatus.OK);
	}
	
	// POST TRANSACTIONS
	@PostMapping
	public ResponseEntity<Transaction> postTransaction(@RequestBody Transaction trans) {
		if(trans.getId() != 0) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		transRepo.save(trans);
		return new ResponseEntity<Transaction>(trans, HttpStatus.CREATED);
	}
	
	// PUT TRANSACTIONS
	@SuppressWarnings("rawtypes")
	@PutMapping("{id}")
	public ResponseEntity putTransaction(@RequestBody Transaction trans) {
		if(trans.getId() <= 0) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		transRepo.save(trans);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	// DELETE TRANSACTIONS
		@SuppressWarnings("rawtypes")
		@DeleteMapping("{id}")
		public ResponseEntity DeleteTransaction(@PathVariable int id) {
			if(id <= 0) {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
			transRepo.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

}
