package Bean_Lifecycle;



public class TrackCoach implements Coach
{
	// Private
	private FortuneService fs;


	// Public
	public TrackCoach() {}
	
	public TrackCoach(FortuneService fs)
	{
		this.fs = fs;
	}

	// Override
	@Override
	public String getDailyWorkout()
	{
		return "Run a hard 5k";
	}

	@Override
	public String getDailyFortune()
	{
		return "Just Do It: " + fs.getFortune();
	}

	// Add an init method
	public void doMyStartupStuff()
	{
		System.out.println("TrackCoach: inside method doMyStartupStuff");
	}
	
	// Add a destroy method
	public void doMyCleanupStuffYoYo()
	{
		System.out.println("TrackCoach: inside method doMyCleanupStuffYoYo");		
	}
}