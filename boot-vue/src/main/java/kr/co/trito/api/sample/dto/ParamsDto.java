package kr.co.trito.api.sample.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class ParamsDto {
	private Integer id;
	private String name;
	private String description;
	private String address;
	private boolean active;
}


