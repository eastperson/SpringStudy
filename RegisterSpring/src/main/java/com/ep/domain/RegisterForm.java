package com.ep.domain;

import java.util.Date;

import lombok.Data;

@Data
public class RegisterForm {
	
	private String id;
	private String pw;
	private String name;
	private String email;
	private String phoneNum;
	private Date dateOfBirth;
	private Grade grade;
	private String prePath;
	
	public UserVO create() {
		
		UserVO user = new UserVO(id,pw,name,email,phoneNum,dateOfBirth);
		
		return user;
	}
}
