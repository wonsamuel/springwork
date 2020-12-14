package com.kh.spring.memo.model.vo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Memo {
	
	private int memoNo;
	private String memo;
	private String password;
	private Date memoDate;

}
