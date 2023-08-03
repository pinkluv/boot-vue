package kr.co.trito.api.sample.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.co.trito.api.sample.dto.EquipMasDto;

@Mapper
public interface SampleMapper {
	List<EquipMasDto> selectAllEquipMas();
	
}
