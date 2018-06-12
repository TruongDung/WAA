package cs545.bank.beans;

import java.io.Serializable;
import java.util.Map;

import javax.enterprise.context.ConversationScoped;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import cs545.bank.domain.Account;

@Named
@RequestScoped
public class DetailAccountController implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private long accountNumber;
	
	private double amount;
	
	private double withdrawn;
	
	private Account account;
	
	@Inject
	private CacheManagerBean cacheManagerBean;
	
	public Account getAccount() {
		FacesContext context = FacesContext.getCurrentInstance();
		Map<String, String> paramMap = context.getExternalContext().getRequestParameterMap();
		System.out.println("accountNumber: " + paramMap.get("accountnumber"));
		if (paramMap.get("accountnumber") != null) {
			accountNumber = Long.parseLong(paramMap.get("accountnumber"));
		}
		if (account == null) {
			account = cacheManagerBean.getAccount(accountNumber);
		}
		return account;
	}

	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public void depositListener() {
		cacheManagerBean.getService().deposit(accountNumber, amount);
		this.getAccount();
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	public void withdrawnListener() {
		cacheManagerBean.getService().withdraw(accountNumber, withdrawn);;
	}

	public double getWithdrawn() {
		return withdrawn;
	}

	public void setWithdrawn(double withdrawn) {
		this.withdrawn = withdrawn;
	}
}
