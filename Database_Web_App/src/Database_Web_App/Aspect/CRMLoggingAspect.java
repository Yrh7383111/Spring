package Database_Web_App.Aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;



@Aspect
@Component
public class CRMLoggingAspect
{
	// Private
	private final Logger logger = Logger.getLogger(getClass().getName());


	// Public

	// Pointcut expression
	@Pointcut("execution(* Database_Web_App.Controller.*.*(..))")
	private void controllerPackage() {}
	
	@Pointcut("execution(* Database_Web_App.Service.*.*(..))")
	private void servicePackage() {}
	
	@Pointcut("execution(* Database_Web_App.DAO.*.*(..))")
	private void DAOPackage() {}
	
	@Pointcut("controllerPackage() || servicePackage() || DAOPackage()")
	private void appFlow() {}

	// Advice implementation
	@Before("appFlow()")
	public void before(JoinPoint joinPoint)
	{
		String method = joinPoint.getSignature().toShortString();
		logger.info("=====>> in @Before: calling method: " + method);
		
		Object[] args = joinPoint.getArgs();
		
		for (Object arg : args) 
			logger.info("=====>> argument: " + arg);
	}
	
	
	// add @AfterReturning advice
	@AfterReturning(pointcut="appFlow()", returning="result")
	public void afterReturning(JoinPoint joinPoint, Object result) 
	{
		String method = joinPoint.getSignature().toShortString();
		logger.info("=====>> in @AfterReturning: from method: " + method);

		logger.info("=====>> result: " + result);
	}
}