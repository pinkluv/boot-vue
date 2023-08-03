package kr.co.trito.user.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import kr.co.trito.user.dto.UserDto;

@Mapper
public interface UserMapper {
	
	List<UserDto> selectAllUsers();
	
	UserDto signin(String email);
	void signup(UserDto userDto);

}
