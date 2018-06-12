package cs545.bank.beans;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class CreateAccountController implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private CacheManagerBean cacheManagerBean;
	
	String name;
	long accountNumber;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	public String createAccount() {
		cacheManagerBean.create(name, accountNumber);
		return "success";
	}
	
}
