package Around_Advice.DAO;


import Around_Advice.Account;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class AccountDAO
{
	// Private
	private String name;
	private String serviceCode;


	// Public
	public List<Account> findAccounts(boolean tripWire)
	{
		if (tripWire)
			throw new RuntimeException("No soup for you!!!");

		// Initialization
		List<Account> accounts = new ArrayList<Account>();

		// Create sample accounts
		Account temp1 = new Account("John", "Silver");
		Account temp2 = new Account("Madhu", "Platinum");
		Account temp3 = new Account("Luca", "Gold");

		// Add them to our accounts list
		accounts.add(temp1);
		accounts.add(temp2);
		accounts.add(temp3);

		return accounts;
	}

	public void addAccount(Account account, boolean VIPFlag)
	{
		System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT");
	}
	
	public boolean doWork()
	{
		
		System.out.println(getClass() + ": doWork()");
		return false;
	}

	public String getName()
	{
		System.out.println(getClass() + ": in getName()");
		return name;
	}

	public void setName(String name)
	{
		System.out.println(getClass() + ": in setName()");
		this.name = name;
	}

	public String getServiceCode()
	{
		System.out.println(getClass() + ": in getServiceCode()");
		return serviceCode;
	}

	public void setServiceCode(String serviceCode)
	{
		System.out.println(getClass() + ": in setServiceCode()");
		this.serviceCode = serviceCode;
	}
}