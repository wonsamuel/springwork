package com.kh.spring.memo.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MemoDaoImpl implements MemoDao {

	@Override
	public List<Map<String, String>> selectMemo(SqlSessionTemplate session) {
		return session.selectList("memo.selectMemo");
	}

	@Override
	public int insertMemo(SqlSessionTemplate session, Map<String, String> map) {
		return session.insert("memo.insertMemo", map);
	}
	
	
}
