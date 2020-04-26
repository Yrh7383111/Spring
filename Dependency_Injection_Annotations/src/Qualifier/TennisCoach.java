package Qualifier;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;



@Component
public class TennisCoach implements Coach
{
	// Private
	private FortuneService fs;


	// Public
	@Autowired
	public TennisCoach(@Qualifier("randomFortuneService") FortuneService fs)
	{
		this.fs = fs;
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
		return fs.getFortune();
	}
}