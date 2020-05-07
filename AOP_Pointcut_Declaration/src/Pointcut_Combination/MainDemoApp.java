package Pointcut_Combination;


import Pointcut_Combination.DAO.AccountDAO;
import Pointcut_Combination.DAO.MembershipDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;



public class MainDemoApp
{
	public static void main(String[] args) 
	{

		// Read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// Get the bean from spring container
		AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
		MembershipDAO memberDAO = context.getBean("membershipDAO", MembershipDAO.class);
		
		// Call the business method
		accountDAO.addAccount(new Account(), true);
		accountDAO.doWork();

		// Setter
		accountDAO.setName("foobar");
		accountDAO.setServiceCode("silver");

		// Getter
		String name = accountDAO.getName();
		String code = accountDAO.getServiceCode();

		// Call the membership business method
		memberDAO.addSillyMember();
		memberDAO.goToSleep();

		// Close the context
		context.close();
	}
}