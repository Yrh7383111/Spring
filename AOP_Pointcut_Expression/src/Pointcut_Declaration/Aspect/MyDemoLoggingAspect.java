package Pointcut_Declaration.Aspect;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class MyDemoLoggingAspect
{
	// All methods in all classes in "Pointcut_Expression" package
	@Before("execution(* Pointcut_Declaration.DAO.*.*(..))")
	public void beforeAddAccountAdvice()
	{
		System.out.println("\n=====>>> Executing @Before advice on addAccount()");
	}
}