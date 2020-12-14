package com.kh.spring.demo.model.service;

import java.util.List;

import com.kh.spring.demo.model.vo.Demo;

public interface DemoService {
	
	int insertDemo(Demo d);
	
	List<Demo> selectDemo();
}
