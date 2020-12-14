package com.kh.spring.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

//public class LoggerInterceptor implements HandlerInterceptor{ 무조건 모든 메소드를 다 구현해야함?
public class LoggerInterceptor extends HandlerInterceptorAdapter{ //원하는 메소드만 선택해서 구현가능?
	
	@Autowired
	private Logger logger;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		logger.debug("===== intercpetor 시작 =====");
		logger.debug(request.getRequestURI());
		
		return super.preHandle(request, response, handler);
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		logger.debug("===== 메소드 종료 후 실행 =====");
		
		super.postHandle(request, response, handler, modelAndView);
	}
	
	


	

}
