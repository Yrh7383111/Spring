package Field_Injection;


import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;



@Component
public class TennisCoach implements Coach
{
	@Autowired
	private FortuneService fortuneService;
	
	// Define a default constructor
	public TennisCoach()
	{
		System.out.println(">> TennisCoach: inside default constructor");
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