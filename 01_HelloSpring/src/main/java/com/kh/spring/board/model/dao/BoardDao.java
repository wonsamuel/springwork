package com.kh.spring.board.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import com.kh.spring.board.model.vo.Attachment;
import com.kh.spring.board.model.vo.Board;

public interface BoardDao {
	
//	List<Map<String,String>> selectBoard(SqlSessionTemplate session);
	
	List<Board> selectBoard(SqlSessionTemplate session, int cPage, int numPerPage);
	
	int selectBoardCount(SqlSessionTemplate session);
	
	int insertBoard(SqlSessionTemplate session, Board b);
	int insertAttachment(SqlSessionTemplate session, Attachment a);
	
	Board boardDetail(SqlSessionTemplate session, int no);
	List<Attachment> selectFiles(SqlSessionTemplate session, int no);

}
