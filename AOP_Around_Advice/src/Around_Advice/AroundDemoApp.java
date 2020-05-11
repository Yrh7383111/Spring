package Around_Advice;


import Around_Advice.Service.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;



public class AroundDemoApp
{
	public static void main(String[] args)
	{
		// Read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// Get the bean from spring container
		TrafficFortuneService theFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);
		
		System.out.println("\nMain Program: AroundDemoApp");
		System.out.println("Calling getFortune");
		
		String data = theFortuneService.getFortune();
		System.out.println("\nMy fortune is: " + data);
		
		System.out.println("Finished");
		
		// Close the context
		context.close();
	}
}