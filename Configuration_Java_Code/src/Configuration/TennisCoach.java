package Configuration;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;



@Component
public class TennisCoach implements Coach
{
	@Autowired
	@Qualifier("randomFortuneService")
	private FortuneService fortuneService;


	// Define a default constructor
	public TennisCoach()
	{
		System.out.println(">> TennisCoach: inside default constructor");
	}

	// Define my init method
	@PostConstruct
	public void doMyStartupStuff()
	{
		System.out.println(">> TennisCoach: inside of doMyStartupStuff()");
	}
	
	// Define my destroy method
	@PreDestroy
	public void doMyCleanupStuff()
	{
		System.out.println(">> TennisCoach: inside of doMyCleanupStuff()");		
	}

	// Override
	@Override
	public String getDailyWorkout() {
		return "Practice your backhand volley";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
}