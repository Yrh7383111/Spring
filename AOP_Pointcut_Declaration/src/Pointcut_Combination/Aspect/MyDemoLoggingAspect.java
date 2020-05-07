package Pointcut_Combination.Aspect;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;



@Aspect
@Component
public class MyDemoLoggingAspect
{
	// All methods in all classes in DAO package
	@Pointcut("execution(* Pointcut_Combination.DAO.*.*(..))")
	private void forDaoPackage() {}

	// All getter methods in all classes in DAO package
	@Pointcut("execution(* Pointcut_Combination.DAO.*.get*(..))")
	private void getter() {}

	// All setter method in all classes in DAO package
	@Pointcut("execution(* Pointcut_Combination.DAO.*.set*(..))")
	private void setter() {}

	// All methods except getter and setter methods in all classes in DAO package
	@Pointcut("forDaoPackage() && !(getter() || setter())")
	private void forDaoPackageNoGetterSetter() {}

	@Before("forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice()
	{
		System.out.println("\n=====>>> Executing @Before advice on method");
	}

	@Before("forDaoPackageNoGetterSetter()")
	public void performApiAnalytics()
	{
		System.out.println("\n=====>>> Performing API analytics");
	}
}