package Component_Scanning;


import org.springframework.context.support.ClassPathXmlApplicationContext;



public class AnnotationDemoApp
{
	public static void main(String[] args)
	{
		// Read spring config file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Component_Scanning/applicationContext.xml");
		
		// Get the bean from spring container
		Coach theCoach = context.getBean("tennisCoach", Coach.class);
		
		// Call a method on the bean
		System.out.println(theCoach.getDailyWorkout());
				
		// Close the context
		context.close();
	}
}