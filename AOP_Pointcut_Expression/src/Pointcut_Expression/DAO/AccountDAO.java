package Pointcut_Expression.DAO;


import Pointcut_Expression.Account;
import org.springframework.stereotype.Component;



@Component
public class AccountDAO
{
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