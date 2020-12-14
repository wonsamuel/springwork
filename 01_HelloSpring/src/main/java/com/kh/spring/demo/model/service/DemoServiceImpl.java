package com.kh.spring.demo.model.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.spring.demo.model.dao.DemoDao;
import com.kh.spring.demo.model.vo.Demo;

//xml방시이 아닌 어노테이션 방식으로 서비스 생성 및 등록
@Service
public class DemoServiceImpl implements DemoService {
	
//	Autowired를 했다면 무조건 그거게 맞는 bean을 spring방식(xml 또는 어노테이션)으로 등록을 해야 함
//	dao 생성할 필요 없어짐
	@Autowired
	private DemoDao dao;
	
//	from sqltemplate in root context
	@Autowired
	private SqlSessionTemplate session;
	
	@Override
	public int insertDemo(Demo d) {
		return dao.insertDemo(session, d);
	}
	
	@Override
	public List<Demo> selectDemo() {
		return dao.selectDemo(session);
	}

}
