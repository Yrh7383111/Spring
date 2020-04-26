package Bean_Scope;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Component
@Scope("prototype")
public class TennisCoach implements Coach
{
	// Private
	@Autowired
	@Qualifier("randomFortuneService")
	private FortuneService fortuneService;
	
	// Define a default constructor
	public TennisCoach()
	{
		System.out.println(">> TennisCoach: inside default constructor");
	}

	// Override
	@Override
	public String getDailyWorkout()
	{
		return "Practice your backhand volley";
	}

	@Override
	public String getDailyFortune()
	{
		return fortuneService.getFortune();
	}
}