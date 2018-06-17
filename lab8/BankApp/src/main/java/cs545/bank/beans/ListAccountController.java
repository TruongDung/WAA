package cs545.bank.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ConversationScoped;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import cs545.bank.domain.Account;

@Named
@RequestScoped
public class ListAccountController implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private CacheManagerBean cacheManagerBean;
	
//	@Inject
//	DetailAccountController detailAccountController;
	
	
	public List<Account> getAllAccounts() {
//		detailAccountController.setAccountNumber(10);
		System.out.println("test123");
		return new ArrayList<>(cacheManagerBean.getAllAccounts());
	}

}
