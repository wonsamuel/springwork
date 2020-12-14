package com.kh.spring.demo.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import com.kh.spring.demo.model.vo.Demo;

public interface DemoDao {
	
	int insertDemo(SqlSessionTemplate session, Demo d);
	
	List<Demo> selectDemo(SqlSessionTemplate session);

}
