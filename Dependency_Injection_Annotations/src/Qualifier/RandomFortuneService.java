package Qualifier;


import org.springframework.stereotype.Component;

import java.util.Random;



@Component
public class RandomFortuneService implements FortuneService
{
	// Create an array of strings
	private final String[] data = {
			"Beware of the wolf in sheep's clothing",
			"Diligence is the mother of good luck",
			"The journey is the reward"
	};

	private final Random myRandom = new Random();


	// Override
	@Override
	public String getFortune()
	{
		int index = myRandom.nextInt(data.length);
		return data[index];
	}
}