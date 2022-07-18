package com.kh.mvc.member.model.vo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Member {
	
	// DB와 Java와의 네이밍 규칙이 다름
	private int no;
	
	private String id;
	
	private String password;
	
	private String role;
	
	private String name;
	
	private String phone;
	
	private String email;
	
	private String address;
	
	private String hobby;
	
	private String status;
	
	// java.util !! (java.sql 아님)
	private Date enrollDate;
	
	private Date modifyDate;
	
}
