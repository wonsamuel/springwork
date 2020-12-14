package com.kh.spring.board.model.service;

import java.util.List;

import com.kh.spring.board.model.vo.Attachment;
import com.kh.spring.board.model.vo.Board;

public interface BoardService {
	
//	List<Map<String,String>> selectBoard();
	
	List<Board> selectBoard(int cPage, int numPerPage);
	
	int selectBoardCount();
	
	int insertBoard(Board b, List<Attachment> files);
	
	Board boardDetail(int no);
	List<Attachment> selectFiles(int no);

}
