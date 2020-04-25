package Bean_Scopes;



public class BaseballCoach implements Coach
{
	// Private
	// Define a private field for the dependency
	private FortuneService fs;


	// Public
	// define a constructor for dependency injection
	public BaseballCoach(FortuneService fs)
	{
		this.fs = fs;
	}
	
	@Override
	public String getDailyWorkout()
	{
		return "Spend 30 minutes on batting practice";
	}

	@Override
	public String getDailyFortune()
	{
		return fs.getFortune();
	}
}