package After_Returning_Advice.Aspect;


import After_Returning_Advice.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;


@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect
{
	@AfterReturning(pointcut="execution(* After_Returning_Advice.DAO.AccountDAO.findAccounts(..))",
					returning="result")
	public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result)
	{
		String method = joinPoint.getSignature().toShortString();
		System.out.println("\n=====>>> Executing @AfterReturning on method: " + method);

		System.out.println("\n=====>>> result is: " + result);

		// Convert the account names to uppercase
		convertAccountNamesToUpperCase(result);
		System.out.println("\n=====>>> result is: " + result);
	}

	@Before("After_Returning_Advice.Aspect.LuvAopExpressions.forDaoPackageNoGetterSetter()")
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

	private void convertAccountNamesToUpperCase(List<Account> result)
	{
		for (Account account : result) 
		{
			String name = account.getName().toUpperCase();
			account.setName(name);
		}
	}
}