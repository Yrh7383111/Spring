package Setter_Injection;


import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;



@Component
public class TennisCoach implements Coach
{
	// Private
	private FortuneService fs;


	// Public
	// Define a default constructor
	public TennisCoach()
	{
		System.out.println(">> TennisCoach: inside default constructor");
	}

	// Define a setter method
	@Autowired
	public void setFortuneService(FortuneService fs)
	{
		System.out.println(">> TennisCoach: inside setFortuneService() method");
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