package com.kh.spring.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfigure {
	
	//Loggerbean으로 등록하기
	@Bean
	public Logger getlogger() {
		return LoggerFactory.getLogger(BeanConfigure.class);
	}
}
