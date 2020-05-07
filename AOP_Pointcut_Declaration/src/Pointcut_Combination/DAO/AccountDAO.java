package Pointcut_Combination.DAO;


import Pointcut_Combination.Account;
import org.springframework.stereotype.Component;



@Component
public class AccountDAO
{
	// Private
	private String name;
	private String serviceCode;


	// Public
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

	public void addAccount(Account account, boolean VIPFlag)
	{
		System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT");
	}

	public boolean doWork()
	{
		System.out.println(getClass() + ": doWork()");
		return false;
	}
}