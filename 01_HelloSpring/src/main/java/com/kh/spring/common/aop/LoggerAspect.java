package com.kh.spring.common.aop;



import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

public class LoggerAspect {
	
	@Autowired
	private Logger logger;
	
	//xml방식으로 구현하기
	
	/* 공통실행 메소드 */
	//패턴에서 지정한 메소드가 실행전에 실행애야하는 메소드 구현
	public void before(JoinPoint joinPoint) {
		
		logger.debug("===== 메소드 실행전 =====");
		Signature sig = joinPoint.getSignature();
		String className = sig.getDeclaringTypeName();
		String methodName = sig.getName();
		logger.debug(className+methodName+"()");
		logger.debug("===== aop 종료 =====");
		
	}
	
	//around메소드 구현하기
	public Object loggerAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
		
		logger.debug("===== 메소드 실행전 =====");
		Signature sig = joinPoint.getSignature();
		String className = sig.getDeclaringTypeName();
		String methodName = sig.getName();
		logger.debug(className+methodName+"()");
		//여기까지가 before
//		Obejct obj = joinPoint.proceed();  //전/후 구분하는 지점
		return joinPoint.proceed();  //전/후 구분하는 지점
		//여기부턴 after
//		logger.debug("===== 실행 후 =====");
//		logger.debug(className+methodName+"()");
//		
//		logger.debug("===== aop 종료 =====");
		
//		return obj;
	}
	

}
