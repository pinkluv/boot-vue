package kr.co.trito.user.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.co.trito.user.dto.UserDto;
import kr.co.trito.user.mapper.UserMapper;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
	private final UserMapper userMapper;
	
	public List<UserDto> selectAllUsers(){
		return userMapper.selectAllUsers();
	}
	
	public UserDto signin(String email) {
		return userMapper.signin(email);
	}
	
	public void signup(UserDto userDto) {
		userMapper.signup(userDto);
	}
}
