package kr.co.trito.user.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import kr.co.trito.user.dto.UserDto;
import kr.co.trito.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {

	private final UserService userService;

 

	@PostMapping("/signin")
	@ResponseBody
	public Map<String, Object> signin(@ModelAttribute UserDto dto) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		UserDto loginResult = userService.signin(dto.getEmail());
		
		map.put("user", loginResult);
		boolean isLogin = false;
		
		if (loginResult != null) {
			String truePw = dto.getPw();
			if (!truePw.equals(dto.getPw())) {
				log.info("wrong password");
			} else {
				isLogin = true;
			}
		}
		
		map.put("result", isLogin);
		
		return map;
	}

	
	@PostMapping("/signup")
	@ResponseBody
	public String signup(@ModelAttribute UserDto dto) {
		log.info("@ModelAttribute - UserDto : {}", dto);
		userService.signup(dto);
		return "success";
	}

}
