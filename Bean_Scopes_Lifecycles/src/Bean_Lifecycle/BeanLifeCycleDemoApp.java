package Bean_Lifecycle;


import org.springframework.context.support.ClassPathXmlApplicationContext;



public class BeanLifeCycleDemoApp
{
	public static void main(String[] args)
	{
		// Load the spring configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Bean_Lifecycle/beanLifeCycle-applicationContext.xml");
				
		// Retrieve bean from spring container
		Coach theCoach = context.getBean("coach", Coach.class);

		System.out.println(theCoach.getDailyWorkout());
		
		// Close the context
		context.close();
	}
}