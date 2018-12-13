package com.cg.main.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class LoggingAspect {
	 private Logger log = Logger.getLogger(this.getClass());
	
@Before ("allAppControllerMethods()")
public void getCallsAdvice(JoinPoint joinpoint) {
	log.info(joinpoint.toString()+" called");
}

@Before ("execution(public boolean com.cg.main.service.CustomerService.validateAccNo(*))")
public void validatingCustomerAdvice(JoinPoint joinpoint) {
	log.info("validating the accNo");
}

@AfterReturning("execution(public boolean com.cg.main.service.CustomerService.validateAccNo(*))")
public void validatedCustomerAdvice(JoinPoint joinpoint) {
	log.info("account found");
}

@AfterThrowing(pointcut="allAppControllerMethods()", throwing="ex")
public void exceptionAdvice(JoinPoint joinpoint, Exception ex) {
	log.info("An exception has been thrown "+ ex);
}

@Pointcut("within(com.cg.main.controller.AppController)")
public void allAppControllerMethods() {}



}
