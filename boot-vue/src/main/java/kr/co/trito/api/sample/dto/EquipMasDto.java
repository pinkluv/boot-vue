package kr.co.trito.api.sample.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class EquipMasDto {
	private String equipId;
	private String equipNm;
}



