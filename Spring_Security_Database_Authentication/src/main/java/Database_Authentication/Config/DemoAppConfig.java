package Database_Authentication.Config;


import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.util.logging.Logger;



@Configuration
@EnableWebMvc
@ComponentScan(basePackages="Database_Authentication")
@PropertySource("classpath:persistence-mysql.properties")
public class DemoAppConfig
{
	// Private
	@Autowired
	private Environment env;
	private final Logger logger = Logger.getLogger(getClass().getName());


	// Public
	@Bean
	public ViewResolver viewResolver()
	{
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		
		return viewResolver;
	}

	@Bean
	public DataSource securityDataSource()
	{
		// Create connection pool
		ComboPooledDataSource securityDataSource = new ComboPooledDataSource();

		// Set the jdbc driver class
		try
		{
			securityDataSource.setDriverClass(env.getProperty("jdbc.driver"));
		}
		catch (PropertyVetoException exc)
		{
			throw new RuntimeException(exc);
		}

		logger.info(">>> jdbc.url=" + env.getProperty("jdbc.url"));
		logger.info(">>> jdbc.user=" + env.getProperty("jdbc.user"));

		// Set database connection props
		securityDataSource.setJdbcUrl(env.getProperty("jdbc.url"));
		securityDataSource.setUser(env.getProperty("jdbc.user"));
		securityDataSource.setPassword(env.getProperty("jdbc.password"));

		// Set connection pool props
		securityDataSource.setInitialPoolSize(getIntProperty("connection.pool.initialPoolSize"));
		securityDataSource.setMinPoolSize(getIntProperty("connection.pool.minPoolSize"));
		securityDataSource.setMaxPoolSize(getIntProperty("connection.pool.maxPoolSize"));
		securityDataSource.setMaxIdleTime(getIntProperty("connection.pool.maxIdleTime"));

		return securityDataSource;
	}

	private int getIntProperty(String name)
	{
		String value = env.getProperty(name);

		int intValue = Integer.parseInt(value);

		return intValue;
	}
}