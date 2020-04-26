package Bean_Scopes;


import org.springframework.context.support.ClassPathXmlApplicationContext;



public class BeanScopeDemoApp
{
	public static void main(String[] args)
	{
		// Load the spring configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Bean_Scopes/beanScope-applicationContext.xml");
				
		// Retrieve bean from spring container
		Coach theCoach = context.getBean("coach", Coach.class);

		Coach alphaCoach = context.getBean("coach", Coach.class);
		
		// Check if they are the same
		boolean result = (theCoach == alphaCoach);
		
		// print out the results
		System.out.println("\nPointing to the same object: " + result);
		
		System.out.println("\nMemory location for theCoach: " + theCoach);

		System.out.println("\nMemory location for alphaCoach: " + alphaCoach + "\n");
	
		// Close the context
		context.close();
	}
}