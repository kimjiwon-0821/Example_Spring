package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.dao.UserDAO;
import com.example.demo.dto.UserDTO;

@SpringBootTest
public class UserDAOTest {
	@Autowired
	private UserDAO userDAO;
	
	@Test
	void getUserListTest() {
		UserDTO userDTO = new UserDTO();
		userDTO.setId(3);
		userDTO.setPassword("ㅇㄹㄴㄹ");
		userDTO.setUsername("ㄴㅇㄹㄴㅇㄹ");
		
		int before = userDAO.getUserList().size();
		userDAO.insertUser(userDTO);
		int after = userDAO.getUserList().size();
		
		assertEquals(before+1, after);
		
		
	}

}
