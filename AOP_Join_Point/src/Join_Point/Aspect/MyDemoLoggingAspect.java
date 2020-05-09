package Join_Point.Aspect;


import Join_Point.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;



@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect
{
	@Before("Join_Point.Aspect.LuvAopExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint joinPoint)
	{
		System.out.println("\n=====>>> Executing @Before advice on method");

		// Get the method signature
		MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
		System.out.println("Method: " + methodSignature);


		// Get the method arguments
		Object[] args = joinPoint.getArgs();

		for (Object arg : args) 
		{
			System.out.println(arg);

			if (arg instanceof Account) 
			{
				Account account = (Account) arg;

				System.out.println("account name: " + account.getName());
				System.out.println("account level: " + account.getLevel());
			}
		}
	}
}