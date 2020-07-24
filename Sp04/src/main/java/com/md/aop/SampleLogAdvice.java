package com.md.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import lombok.extern.log4j.Log4j;

@Aspect
@Log4j
@Component
public class SampleLogAdvice {
	/*@Before("execution(* soo.md.service.SampleLogService*.*(..))")
	public void logBefore() {
		log.info("#logBefore() 수행");
	}*/
	@Before("execution(* com.md.service.SampleLogService*.add(String,String)) && args(str1,str2)")
	public void logBeforeWithParam(String str1, String str2) {
		log.info("#logBeforeWithParam() 수행  str1: "+str1+", str2: " + str2);
	}
	
	@Around("execution(* com.md.service.SampleLogService*.*(..))")
	public Object longTime(ProceedingJoinPoint pjp) {
		long start = System.currentTimeMillis();
		
		Object result = null;
		try {
			 result = pjp.proceed(); //비지니스 메소드로 진행하도록()하는 메소드  
		}catch(Throwable t) {}
		
		long end = System.currentTimeMillis();
		log.info("#수행 시간: " + (end-start) + "ms");
		
		return result;
	}
	
	@After("execution(* com.md.service.SampleLogService*.*(..))")
	public void logAfter() {
		log.info("#logAfter() 수행");
	}
	@AfterThrowing(pointcut="execution(* com.md.service.SampleLogService*.*(..))", throwing="exception")
	public void logAfterThrowing(Exception exception) {
		log.info("#logAfterThrowing() 수행 exception: "+exception);
	}
}
