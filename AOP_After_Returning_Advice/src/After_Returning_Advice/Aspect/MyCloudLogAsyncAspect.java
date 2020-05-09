package After_Returning_Advice.Aspect;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


@Aspect
@Component
@Order(1)
public class MyCloudLogAsyncAspect
{
	@Before("After_Returning_Advice.Aspect.LuvAopExpressions.forDaoPackageNoGetterSetter()")
	public void logToCloudAsync()
	{
		System.out.println("\n=====>>> Logging to Cloud in async fashion");		
	}
}