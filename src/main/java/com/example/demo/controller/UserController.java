package com.example.demo.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dao.UserDAO;
import com.example.demo.dto.UserDTO;

@Controller
public class UserController {
	@Autowired
	private UserDAO userDAO;
	

	
	@GetMapping("user/list")
	public @ResponseBody List<UserDTO> getUserList(){
		return userDAO.getUserList();
	}
	
	@GetMapping("user/get/{id}")
	public @ResponseBody UserDTO getUser(@PathVariable int id,UserDTO userDTO) throws Exception {
		userDTO.setId(id);
		UserDTO findUser = userDAO.getUser(id);
		return findUser;
	}
	
	@PutMapping("user")
	public @ResponseBody String updateUser(UserDTO userDTO) throws Exception{
		UserDTO findUser = userDAO.getUser(userDTO.getId());
		findUser.setPassword(userDTO.getPassword());
		findUser.setUsername(userDTO.getUsername());
		userDAO.updateUser(findUser);
		return "회원 정보를 수정했습니다.";
	}
	
	@DeleteMapping("user/{id}")
	public @ResponseBody String deleteUser(@PathVariable int id,UserDTO userDTO) {
		userDTO.setId(id);
		userDAO.deleteUser(userDTO);
		return "회원을 삭제하였스빈다.";
	}
	
	
	//예외 처리에 대해 이해가 안된다면 https://mangkyu.tistory.com/204
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<String> foundException(NoSuchElementException exception){
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
	}
}
