package com.example.demo.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.UserDTO;

@Repository
public class UserDAO{
	
	@Autowired
	private SqlSessionTemplate mybatis;
	
	public void insertUser(UserDTO userDTO) {
		mybatis.insert("insertUser",userDTO);
	}
	
	public void updateUser(UserDTO userDTO) {
		mybatis.update("updateUser", userDTO);
	}
	
	public void deleteUser(UserDTO userDTO) {
		mybatis.delete("deleteUser", userDTO);
	}
	
	public UserDTO getUser(int id) {
		return mybatis.selectOne("getUser", id);
	}
	
	public List<UserDTO> getUserList(){
		return mybatis.selectList("getUserList");
	}
}
