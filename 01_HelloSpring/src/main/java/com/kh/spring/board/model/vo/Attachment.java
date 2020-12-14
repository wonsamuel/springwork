package com.kh.spring.board.model.vo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Attachment {

	private int attachmentNo;
	private int boardNo;
	private String originalFilename;
	private String renamedFilename;
	private Date uploadDate;
	private int downLoadCount;
	private String Status;
}
