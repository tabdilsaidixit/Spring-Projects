package com.learning.springdemo.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMLoggingAspect {
	//setup logger
	private Logger myLogger = Logger.getLogger(getClass().getName());
	
	//define pointcuts
	@Pointcut("execution(* com.learning.springdemo.controller.*.*(..))")
	private void forControllerPackage() {}
	
	@Pointcut("execution(* com.learning.springdemo.service.*.*(..))")
	private void forServicePackage() {}
	
	@Pointcut("execution(* com.learning.springdemo.dao.*.*(..))")
	private void forDaoPackage() {}
	
	@Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
	private void forAppFlow() {}
	//before advice
	
	@Before("forAppFlow()")
	public void before(JoinPoint theJoinPoint) {
		String theMethod = theJoinPoint.getSignature().toShortString();
		myLogger.info("===> in @Before: calling method: "+theMethod);
		
		Object[] args = theJoinPoint.getArgs();
		
		for(Object tempArg: args) {
			myLogger.info("===>> argument: "+ tempArg);
		}
	}
	
	//after returning advice
	@AfterReturning(
			pointcut = "forAppFlow()",
			returning = "theResult"
			)
	public void afterReturning(JoinPoint theJoinPoint, Object theResult) {
		String theMethod = theJoinPoint.getSignature().toShortString();
		myLogger.info("===> in @AfterReturning: calling method: "+theMethod);
		
		myLogger.info("===>> result:" + theResult);
	}

}
