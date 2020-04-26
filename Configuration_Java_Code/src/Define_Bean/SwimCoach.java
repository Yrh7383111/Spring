package Define_Bean;



public class SwimCoach implements Coach
{
	// Private
	private FortuneService fs;


	// Public
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
}