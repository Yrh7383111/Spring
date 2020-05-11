package After_Advice;


import After_Advice.DAO.AccountDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;


public class AfterThrowingDemoApp
{
	public static void main(String[] args) 
	{
		// Read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// Get the bean from spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		// Call method to find the accounts
		List<Account> account = null;
		
		try
		{
			boolean tripWire = true;
			account = theAccountDAO.findAccounts(tripWire);
		}
		catch (Exception exc)
		{
			System.out.println("\n\nMain Program ... caught exception: " + exc);
		}
		
		// Display the accounts
		System.out.println("\n\nMain Program: AfterThrowingDemoApp");
		System.out.println("----");
		System.out.println(account);
		
		// Close the context
		context.close();
	}
}