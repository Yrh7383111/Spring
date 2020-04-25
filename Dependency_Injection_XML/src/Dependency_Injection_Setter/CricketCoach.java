package Dependency_Injection_Setter;



public class CricketCoach implements Coach
{
	// Private
	private FortuneService fs;


	// Public
	// create a no-arg constructor
	public CricketCoach()
	{
		System.out.println("CricketCoach: inside no-arg constructor");
	}
	
	// Setter method
	public void setFortuneService(FortuneService fs)
	{
		System.out.println("CricketCoach: inside setter method - setFortuneService");
		this.fs = fs;
	}

	// Override
	@Override
	public String getDailyWorkout() {
		return "Practice fast bowling for 15 minutes";
	}

	@Override
	public String getDailyFortune() {
		return fs.getFortune();
	}
}