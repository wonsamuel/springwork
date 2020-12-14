package com.kh.spring.memo.model.service;

import java.util.List;
import java.util.Map;

public interface MemoService {
	
	List<Map<String, String>> selectMemo();
	
	int insertMemo(Map<String,String> map);
	
	

}
