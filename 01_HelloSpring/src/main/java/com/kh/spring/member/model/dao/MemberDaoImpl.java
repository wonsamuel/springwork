package com.kh.spring.member.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.spring.member.model.vo.Member;

@Repository
public class MemberDaoImpl implements MemberDao {

	@Override
	public int insertMember(SqlSessionTemplate session, Member m) {
		
//		int result = 0;
//		try {
//			result = session.insert("member.insertMember",m);
//		}catch(Exception e) {
//			
//		}
		
		return session.insert("member.insertMember",m);
	}

	@Override
	public Member selectMember(SqlSessionTemplate session, String userId) {
		return session.selectOne("member.selectMember", userId);
	}
	
	

}
