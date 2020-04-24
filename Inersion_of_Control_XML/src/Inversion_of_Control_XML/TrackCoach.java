package Inversion_of_Control_XML;



public class TrackCoach implements Coach
{
	@Override
	public String getDailyWorkout()
	{
		return "Run a hard 5k";
	}
}