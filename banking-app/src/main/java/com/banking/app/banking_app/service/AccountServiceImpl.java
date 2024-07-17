package com.banking.app.banking_app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banking.app.banking_app.entity.Account;
import com.banking.app.banking_app.repo.AccountRepos;
@Service
public class AccountServiceImpl implements AccountService{
	
	@Autowired
	AccountRepos repo;
	@Override
	public Account createAccount(Account account) {
		Account account_saved = repo.save(account);
		return account_saved;
	}

	@Override
	public Account getAcctDtlsinRepos(Long accountNumber) {
		Optional<Account> account = repo.findById(accountNumber);
		if (account.isEmpty()) {
			throw new RuntimeException("Account number is invalid");
		}
		Account discvdAcct = account.get(); 
		return discvdAcct;
	}

	@Override
	public Account cashDep(Long accountNumber, Double trnAmt) {
		Optional<Account> account = repo.findById(accountNumber);
		if (account.isEmpty()) {
			throw new RuntimeException("Account number is invalid");
		}
		Account crAcct = account.get();
		Double amtAfterTran = crAcct.getAccount_balance() + trnAmt;
		crAcct.setAccount_balance(amtAfterTran);
		repo.save(crAcct);
		return crAcct;

	}

	@Override
	public Account cashWithdrwl(Long accountNumber, Double trnAmt) {
		Optional<Account> account = repo.findById(accountNumber);
		/*if (account.isEmpty()) {
			throw new RuntimeException("Account number is invalid");
		}*/
		getAcctDtlsinRepos(accountNumber);
		Account drAcct = account.get();
		Double acctBal = drAcct.getAccount_balance() - trnAmt;
		drAcct.setAccount_balance(acctBal);
		repo.save(drAcct);
		return drAcct;
	}

	@Override
	public void closeAcct(Long accountNumber) {
		getAcctDtlsinRepos(accountNumber);
		repo.deleteById(accountNumber);
		
		
	}
	

}
