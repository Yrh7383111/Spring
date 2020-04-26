package Property_File;



public class SadFortuneService implements FortuneService
{
	@Override
	public String getFortune() {
		return "Today is a sad day";
	}
}