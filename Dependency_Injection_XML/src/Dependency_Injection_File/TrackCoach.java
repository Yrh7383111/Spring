package Dependency_Injection_File;



public class TrackCoach implements Coach
{
	// Private
	private FortuneService fortuneService;


	// Public
	public TrackCoach() {}
	
	public TrackCoach(FortuneService fortuneService)
	{
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout()
	{
		return "Run a hard 5k";
	}

	// Override
	@Override
	public String getDailyFortune()
	{
		return "Just Do It: " + fortuneService.getFortune();
	}

}