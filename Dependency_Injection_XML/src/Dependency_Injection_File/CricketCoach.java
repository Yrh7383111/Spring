package Dependency_Injection_File;



public class CricketCoach implements Coach
{
	// Private
	private FortuneService fortuneService;
	private String emailAddress;
	private String team;
	

	// Public
	// Create a no-arg constructor
	public CricketCoach()
	{
		System.out.println("CricketCoach: inside no-arg constructor");
	}
	
	public String getEmailAddress()
	{
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress)
	{
		System.out.println("CricketCoach: inside setter method - setEmailAddress");
		this.emailAddress = emailAddress;
	}

	public String getTeam()
	{
		return team;
	}

	public void setTeam(String team)
	{
		System.out.println("CricketCoach: inside setter method - setTeam");
		this.team = team;
	}

	// Setter method
	public void setFortuneService(FortuneService fortuneService)
	{
		System.out.println("CricketCoach: inside setter method - setFortuneService");
		this.fortuneService = fortuneService;
	}

	// Override
	@Override
	public String getDailyWorkout()
	{
		return "Practice fast bowling for 15 minutes";
	}

	@Override
	public String getDailyFortune()
	{
		return fortuneService.getFortune();
	}
}