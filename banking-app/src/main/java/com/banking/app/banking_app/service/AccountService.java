package com.banking.app.banking_app.service;
import java.util.List;
import com.banking.app.banking_app.entity.Account;


public interface AccountService {
	public Account createAccount(Account account);
	public Account getAcctDtlsinRepos(Long accountNumber);
	public Account cashDep(Long accountNumber, Double trnAmt);
	public Account cashWithdrwl(Long accountNumber, Double trnAmt);
	public void closeAcct(Long accountNumber);
}
