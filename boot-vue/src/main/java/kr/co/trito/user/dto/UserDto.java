package kr.co.trito.user.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDto {
	private String id;
	private String pw;
	private String name;
	private String email;
	private String phone;
	private String desc;
	
}
