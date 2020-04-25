package Dependency_Injection_Setter;


import org.springframework.context.support.ClassPathXmlApplicationContext;



public class HelloSpringApp
{
	public static void main(String[] args)
	{
		// Load the spring configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Dependency_Injection_Setter/applicationContext.xml");
				
		// Retrieve bean from spring container
		Coach theCoach = context.getBean("coach", Coach.class);
		
		// Call methods on the bean
		System.out.println(theCoach.getDailyWorkout());
		
		// Let's call our new method for fortunes
		System.out.println(theCoach.getDailyFortune());
		
		// Close the context
		context.close();
	}
}