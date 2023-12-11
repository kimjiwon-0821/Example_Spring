package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.UserDTO;


@RestController
public class HelloController {
	
	/* @Controller 실습 */
	@GetMapping("html") //호출 URL
	public String getHtml() {
		System.out.println("HTML 파일을 요청하였습니다.");
		return "redirect:html/hello.html";
	}
	
	@GetMapping("image")
	public String getImage() {
		System.out.println(" 이미지 파일이 요청되었습니다.");
		//redirect에 관하여 계속 이해가 되지 않는다면 https://blog.naver.com/PostView.nhn?isHttpsRedirect=true&blogId=sim4858&logNo=221007278858
		return "redirect:image/kong.jpg";
	}
	
	@GetMapping("jsp")
	public String getJsp(Model model) {
		System.out.println("JSP 파일이 요청되었습니다.");
		model.addAttribute("username","kimjiwon");
		//return "redirect:html"; //이렇게 보내면 HTML 파일이 요청됨
		return "hello";
	}
	
	/* @RestController 실습 */
	//controller과 RestController의 차이가 이해가 되지 않는다면 https://mangkyu.tistory.com/49
	
	@GetMapping("kong") //select
	public UserDTO httpGet() {
		UserDTO userDTO = UserDTO.builder()
				.id(1)
				.username("kimjiwon")
				.password("kim123")
				.build();
		return userDTO;
	}
	
	@PostMapping("kong") //insert
	public String httpPost(UserDTO userDTO) {
		return "POST 요청 처리 입력값 : " +userDTO.toString();
	}
	
	@PutMapping("kong") //update
	public String httpPut(UserDTO userDTO) {
		return "PUT 요청 처리 입력값 : " +userDTO.toString();
	}
	
	@DeleteMapping("kong") //delete
	public String httpDelete(UserDTO userDTO) {
		return "DELETE 요청 처리 입력값 : "+userDTO.getId();
	}

}
