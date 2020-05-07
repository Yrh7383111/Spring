package Before_Advice;


import Before_Advice.DAO.AccountDAO;
import Before_Advice.DAO.MembershipDAO;
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
		accountDAO.addAccount();
		memberDAO.addSillyMember();
				
		// Close the context
		context.close();
	}
}