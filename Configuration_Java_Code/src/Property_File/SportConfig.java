package Property_File;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;



@Configuration
@PropertySource("classpath:Property_File/sport.properties")
public class SportConfig
{

	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceHolderConfigurer()
	{
		return new PropertySourcesPlaceholderConfigurer();
	}
	
	// Define bean for our sad fortune service
	@Bean
	public FortuneService sadFortuneService()
	{
		return new SadFortuneService();
	}
	
	// Define bean for our swim coach AND inject dependency
	@Bean
	public Coach swimCoach()
	{
		return new SwimCoach(sadFortuneService());
	}
}