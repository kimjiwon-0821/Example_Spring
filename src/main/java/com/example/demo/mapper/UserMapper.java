package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo.dto.UserDTO;

@Mapper
public interface UserMapper {
	@Insert("INSERT INTO USER VALUES(#{id},#{username},#{password})")
	public void insertUser(UserDTO userDTO);
	
	@Update("UPDATE USER SET PASSWORD=#{password},USERNAME=#{username} WHERE ID=#{id}")
	public void updateUser(UserDTO userDTO);
	
	@Delete("DELETE FROM USER WHERE ID=#{id}")
	public void deleteUser(UserDTO userDTO);
	
	@Select("SELECT * FROM USER WHERE ID=#{id}")
	public UserDTO getUser(int id);
	
	@Select("SELECT * FROM USER")
	public List<UserDTO> getUserList();

}
