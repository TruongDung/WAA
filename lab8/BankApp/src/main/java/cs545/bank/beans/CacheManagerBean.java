package cs545.bank.beans;

import java.util.Collection;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import cs545.bank.domain.Account;
import cs545.bank.service.AccountService;

@Named
@ApplicationScoped
public class CacheManagerBean {
	private AccountService service = new AccountService();
	
	public void create(String name, long accountNumer) {
		service.createAccount(accountNumer, name);
		printListAccount();
	}
	
	public Collection<Account> getAllAccounts() {
		return service.getAllAccounts();
	}
	
	public Account getAccount(long accountNumber) {
		return service.getAccount(accountNumber);
	}
	
	public void printListAccount() {
		System.out.println("Total accounts:" + service.getAllAccounts().size());
	}

	public AccountService getService() {
		return service;
	}
	
}
