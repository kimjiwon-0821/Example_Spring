package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor	//기본 생성자 생성
@AllArgsConstructor	// 모든 멤버변수 초기화하는 생성자 생성
@Builder
public class UserDTO {
	private int id;
	private String username;
	private String password;
	

}
