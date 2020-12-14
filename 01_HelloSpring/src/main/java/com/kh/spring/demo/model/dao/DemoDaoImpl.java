package com.kh.spring.demo.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.spring.demo.model.vo.Demo;

//spring bean으로 어노테이션 방식으로 dao 등록
@Repository
public class DemoDaoImpl implements DemoDao {

	@Override
	public int insertDemo(SqlSessionTemplate session, Demo d) {
		return session.insert("demo.insertDemo",d);
	}
	
	@Override
	public List<Demo> selectDemo(SqlSessionTemplate session) {
		// TODO Auto-generated method stub
		return session.selectList("demo.selectDemo");
	}

}
