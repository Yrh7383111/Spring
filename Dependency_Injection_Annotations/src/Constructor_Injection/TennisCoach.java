package Constructor_Injection;


import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;



@Component
public class TennisCoach implements Coach
{
	// Private
	private FortuneService fs;


	// Public
	@Autowired
	public TennisCoach(FortuneService fs)
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