package Property_File;


import org.springframework.beans.factory.annotation.Value;



public class SwimCoach implements Coach
{
	// Private
	private FortuneService fs;

	@Value("${foo.email}")
	private String email;
	
	@Value("${foo.team}")
	private String team;
	
	public SwimCoach(FortuneService fs)
	{
		this.fs = fs;
	}
	
	@Override
	public String getDailyWorkout()
	{
		return "Swim 1000 meters as a warm up.";
	}

	@Override
	public String getDailyFortune()
	{
		return fs.getFortune();
	}

	public String getEmail()
	{
		return email;
	}

	public String getTeam()
	{
		return team;
	}
}