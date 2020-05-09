package Ordering_Aspect.Aspect;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class LuvAopExpressions
{
	@Pointcut("execution(* Ordering_Aspect.DAO.*.*(..))")
	public void forDaoPackage() {}
	
	// Create pointcut for getter methods
	@Pointcut("execution(* Ordering_Aspect.DAO.*.get*(..))")
	public void getter() {}
	
	// create pointcut for setter methods
	@Pointcut("execution(* Ordering_Aspect.DAO.*.set*(..))")
	public void setter() {}
	
	// Create pointcut: include package ... exclude getter/setter
	@Pointcut("forDaoPackage() && !(getter() || setter())")
	public void forDaoPackageNoGetterSetter() {}
}