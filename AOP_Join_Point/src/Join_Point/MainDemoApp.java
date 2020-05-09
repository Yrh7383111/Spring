package Join_Point;


import Join_Point.DAO.AccountDAO;
import Join_Point.DAO.MembershipDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;



public class MainDemoApp
{
	public static void main(String[] args) 
	{
		// Read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// Get the bean from spring container
		AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		// Get membership bean from spring container
		MembershipDAO membershipDAO = context.getBean("membershipDAO", MembershipDAO.class);
				
		// Call the business method
		Account myAccount = new Account();
		myAccount.setName("Madhu");
		myAccount.setLevel("Silver");
		accountDAO.addAccount(myAccount, true);
		accountDAO.doWork();
		
		// Call the account dao getter/setter methods
		accountDAO.setName("foobar");
		accountDAO.setServiceCode("silver");

		String name = accountDAO.getName();
		String code = accountDAO.getServiceCode();
		
		// Call the membership business method
		membershipDAO.addSillyMember();
		membershipDAO.goToSleep();
		
		// Close the context
		context.close();
	}
}