package Join_Point.Aspect;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


@Aspect
@Component
@Order(6)
public class MyZetaAspect
{
	@Before("Join_Point.Aspect.LuvAopExpressions.forDaoPackageNoGetterSetter()")
	public void performApiAnalytics()
	{
		System.out.println("\n=====>>> FUNNY");		
	}
}