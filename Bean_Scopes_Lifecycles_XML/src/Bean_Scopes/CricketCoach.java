package Bean_Scopes;



public class CricketCoach implements Coach
{
	// Private
	private FortuneService fs;
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
	public void setFortuneService(FortuneService fs)
	{
		System.out.println("CricketCoach: inside setter method - setFortuneService");
		this.fs = fs;
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
		return fs.getFortune();
	}
}