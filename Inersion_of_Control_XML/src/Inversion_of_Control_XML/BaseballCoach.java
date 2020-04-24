package Inversion_of_Control_XML;



public class BaseballCoach implements Coach
{
	@Override
	public String getDailyWorkout()
	{
		return "Spend 30 minutes on batting practice";
	}
}