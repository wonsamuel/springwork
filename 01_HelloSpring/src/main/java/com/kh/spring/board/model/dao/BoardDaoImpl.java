package com.kh.spring.board.model.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.spring.board.model.vo.Attachment;
import com.kh.spring.board.model.vo.Board;

@Repository
public class BoardDaoImpl implements BoardDao {



//	@Override
//	public List<Map<String, String>> selectBoard(SqlSessionTemplate session) {
//		return session.selectList("board.selectBoard");
//	}
	
	@Override
	public List<Board> selectBoard(SqlSessionTemplate session, int cPage, int numPerPage) {
		return session.selectList("board.selectBoard",null, new RowBounds((cPage-1)*numPerPage, numPerPage));
	}

	@Override
	public int selectBoardCount(SqlSessionTemplate session) {
		return session.selectOne("board.selectBoardCount");
	}

	@Override
	public int insertBoard(SqlSessionTemplate session, Board b) {
		return session.insert("board.insertBoard", b);
	}

	@Override
	public int insertAttachment(SqlSessionTemplate session, Attachment a) {
		return session.insert("board.insertAttachment", a);
	}

	@Override
	public Board boardDetail(SqlSessionTemplate session, int no) {
		return session.selectOne("board.boardDetail", no);
	}

	@Override
	public List<Attachment> selectFiles(SqlSessionTemplate session, int no) {
		return session.selectList("board.selectFiles",no);
	}
	
	
	
	
	

	
	
}
