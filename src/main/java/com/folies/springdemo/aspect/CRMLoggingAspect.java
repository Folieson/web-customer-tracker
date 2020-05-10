package com.folies.springdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class CRMLoggingAspect {
	private final Logger logger = Logger.getLogger(getClass().getName());

	@Pointcut("execution(* com.folies.springdemo.controller.*.*(..))")
	private void forControllerPackage() {}

	@Pointcut("execution(* com.folies.springdemo.service.*.*(..))")
	private void forServicePackage() {}

	@Pointcut("execution(* com.folies.springdemo.dao.*.*(..))")
	private void forDaoPackage() {}

	@Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
	private void forAppFlow() {}

	@Before("forAppFlow()")
	public void before(JoinPoint joinPoint) {
		var method = joinPoint.getSignature().toShortString();
		logger.info("=====>> in @Before: calling method: " + method);
		var args = joinPoint.getArgs();
		for (Object arg : args) {
			logger.info("=====> argument: " + arg);
		}
	}

	@AfterReturning(pointcut = "forAppFlow()", returning = "result")
	public void afterReturning(JoinPoint joinPoint, Object result) {
		var method = joinPoint.getSignature().toShortString();
		logger.info("=====>> in @AfterReturning: calling method: " + method);
		logger.info("=====> result: " + result);
	}
}
