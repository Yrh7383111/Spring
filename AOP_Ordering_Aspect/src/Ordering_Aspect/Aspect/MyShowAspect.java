package Ordering_Aspect.Aspect;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;



@Aspect
@Component
@Order(6)
public class MyShowAspect
{
	@Before("Ordering_Aspect.Aspect.LuvAopExpressions.forDaoPackageNoGetterSetter()")
	public void performApiAnalytics()
	{
		System.out.println("\n=====>>> SHOW");		
	}
}