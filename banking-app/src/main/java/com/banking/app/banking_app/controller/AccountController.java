package com.banking.app.banking_app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.banking.app.banking_app.entity.*;
import com.banking.app.banking_app.service.AccountService;

@RestController
@RequestMapping("/account")
public class AccountController {
	
	@Autowired
	AccountService service;

	//create the account
	@PostMapping("/create")
	public ResponseEntity createAccount(@RequestBody Account account) {	
			Account createAccount = service.createAccount(account);
			return ResponseEntity.status(HttpStatus.CREATED).body(createAccount);
	}

	@GetMapping("/{accountNumber}")
	public Account getAcctDtlsinRepos(@PathVariable Long accountNumber) {
		Account account = service.getAcctDtlsinRepos(accountNumber);
		return account;
	}
	
	@PutMapping("/cashDeposit/{accountNumber}/{trnAmt}")
	public Account cashDep(@PathVariable Long accountNumber, @PathVariable Double trnAmt) {
		Account account =  service.cashDep(accountNumber, trnAmt);
		return account;
	}
	
	@PutMapping("/cashWdrl/{accountNumber}/{trnAmt}")
	public Account cashWithdrwl(@PathVariable Long accountNumber, @PathVariable Double trnAmt) {
		Account account = service.cashWithdrwl(accountNumber, trnAmt);
		return account;
	}
	
	@DeleteMapping("/delete/{accountNumber}")
	public ResponseEntity closeAcct(@PathVariable Long accountNumber) {
		service.closeAcct(accountNumber);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body("Account number: "+accountNumber+" is successfully closed");
		
	}
	
	
	
	
	
	
}
