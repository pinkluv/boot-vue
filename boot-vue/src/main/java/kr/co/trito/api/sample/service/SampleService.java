package kr.co.trito.api.sample.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.co.trito.api.sample.dto.EquipMasDto;
import kr.co.trito.api.sample.mapper.SampleMapper;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SampleService {
	private final SampleMapper sampleMapper;
	public List<EquipMasDto> selectAllEquipMas() {
		return sampleMapper.selectAllEquipMas();
	}
}
