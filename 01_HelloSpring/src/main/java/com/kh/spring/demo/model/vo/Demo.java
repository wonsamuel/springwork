package com.kh.spring.demo.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Demo {
	
	/* 롬벅이라는 라이브러리? */
	
	private int devNo;
	private String devName;
	private int devAge;
	private String devEmail;
	private String devGender;
	private String[] devLang;
	
	

}
