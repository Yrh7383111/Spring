package Dependency_Injection_File;



public class MyApp
{

	public static void main(String[] args)
	{
		Coach theCoach = new TrackCoach();
		
		System.out.println(theCoach.getDailyWorkout());
	}
}