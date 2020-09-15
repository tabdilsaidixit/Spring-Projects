package com.learning.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
	
	@Pointcut("execution(* com.learning.aopdemo.dao.*.*(..))")
	private void forDaoPackage() {	}
	
	
	@Before("forDaoPackage()")
	public void beforeLogInfoAspectAdvice() {
		System.out.println("\n =====> before ");
	}

}
