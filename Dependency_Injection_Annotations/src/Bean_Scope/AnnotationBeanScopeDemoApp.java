package Bean_Scope;


import org.springframework.context.support.ClassPathXmlApplicationContext;



public class AnnotationBeanScopeDemoApp
{
	public static void main(String[] args)
	{

		// load spring config file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Bean_Scope/applicationContext.xml");
				
		// Retrieve bean from spring container
		Coach theCoach = context.getBean("tennisCoach", Coach.class);

		Coach alphaCoach = context.getBean("tennisCoach", Coach.class);
		
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