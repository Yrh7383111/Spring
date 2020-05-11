package Around_Advice.Aspect;


import Around_Advice.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.logging.Logger;


@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect
{
	// Private
	private Logger myLogger = Logger.getLogger(getClass().getName());


	// Public
	@Around("execution(* Around_Advice.Service.*.getFortune(..))")
	public Object aroundGetFortune(ProceedingJoinPoint proceedingJoinPoint) throws Throwable
	{
		String method = proceedingJoinPoint.getSignature().toShortString();
		myLogger.info("\n=====>>> Executing @Around on method: " + method);

		long begin = System.currentTimeMillis();

		Object result = null;

		try
		{
			result = proceedingJoinPoint.proceed();
		}
		catch (Exception e)
		{
			myLogger.warning(e.getMessage());
			// result = "Major accident! But no worries, " + "your private AOP helicopter is on the way!";
			throw e;
		}

		long end = System.currentTimeMillis();

		long duration = end - begin;
		myLogger.info("\n=====> Duration: " + duration / 1000.0 + " seconds");

		return result;
	}

	@After("execution(* Around_Advice.DAO.AccountDAO.findAccounts(..))")
	public void afterFinallyFindAccountsAdvice(JoinPoint joinPoint) 
	{
		String method = joinPoint.getSignature().toShortString();
		myLogger.info("\n=====>>> Executing @After (finally) on method: " + method);
	}
	
	@AfterThrowing(pointcut="execution(* Around_Advice.DAO.AccountDAO.findAccounts(..))",
			 	   throwing="exc")
	public void afterThrowingFindAccountsAdvice(JoinPoint joinPoint, Throwable exc) 
	{
		String method = joinPoint.getSignature().toShortString();
		myLogger.info("\n=====>>> Executing @AfterThrowing on method: " + method);
		myLogger.info("\n=====>>> The exception is: " + exc);
	}

	@AfterReturning(pointcut="execution(* Around_Advice.DAO.AccountDAO.findAccounts(..))",
					returning="result")
	public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result)
	{
		String method = joinPoint.getSignature().toShortString();
		myLogger.info("\n=====>>> Executing @AfterReturning on method: " + method);

		myLogger.info("\n=====>>> result is: " + result);

		// Convert the account names to uppercase
		convertAccountNamesToUpperCase(result);
		myLogger.info("\n=====>>> result is: " + result);
	}

	@Before("Around_Advice.Aspect.LuvAopExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint joinPoint)
	{
		myLogger.info("\n=====>>> Executing @Before advice on method");

		// Get the method signature
		MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
		myLogger.info("Method: " + methodSignature);


		// Get the method arguments
		Object[] args = joinPoint.getArgs();

		for (Object arg : args) 
		{
			myLogger.info(arg.toString());

			if (arg instanceof Account)
			{
				Account account = (Account) arg;

				myLogger.info("account name: " + account.getName());
				myLogger.info("account level: " + account.getLevel());
			}
		}
	}

	private void convertAccountNamesToUpperCase(List<Account> result)
	{
		for (Account account : result)
		{
			String name = account.getName().toUpperCase();
			account.setName(name);
		}
	}
}