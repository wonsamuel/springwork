package com.kh.spring.member.model.vo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Member {
	
	private String userId;
	private String password;
	private String userName;
	private String gender;
	private int age;
	private String email;
	private String phone;
	private String address;
	private String[] hobby;
	
}
