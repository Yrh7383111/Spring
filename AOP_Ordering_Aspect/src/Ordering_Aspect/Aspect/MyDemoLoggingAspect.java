package Ordering_Aspect.Aspect;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect
{
	@Before("Ordering_Aspect.Aspect.LuvAopExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice()
	{
		System.out.println("\n=====>>> Executing @Before advice on method");		
	}
}