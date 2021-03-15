package com.example.demo.subway.usecase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.subway.domain.StationInfoDto;
import com.example.demo.subway.domain.Subway;
import com.example.demo.subway.domain.SubwayDto;
import com.example.demo.subway.domain.SubwayInputDto;
import com.example.demo.subway.infra.SubwayRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class FindNearestSubwayUseCase {

	final private SubwayRepository subwayRepository;
	private final ModelMapper modelMapper;

	@Autowired
	public FindNearestSubwayUseCase(SubwayRepository subwayRepository, ModelMapper modelMapper) {
		this.subwayRepository = subwayRepository;
		this.modelMapper = modelMapper;
	}

	public StationInfoDto findNearestSubway(SubwayInputDto subwayInputDTO) {
		List<Subway> preResult = new ArrayList<Subway>();
		preResult = subwayRepository.findAllByXBetweenAndYBetween(
			subwayInputDTO.getMinX(),
			subwayInputDTO.getMaxX(),
			subwayInputDTO.getMinY(),
			subwayInputDTO.getMaxY()
		);
		double x = subwayInputDTO.getX();
		double y = subwayInputDTO.getY();
		Collections.sort(preResult, new Comparator<Subway>() {
			@Override
			public int compare(Subway s1, Subway s2) {
				if (s1.getDistance(x, y) < s2.getDistance(x, y)) {
					return -1;
				} else {
					return 1;
				}
			}
		});
		List<SubwayDto> result = new ArrayList<SubwayDto>();
		for (int i = 0; i < preResult.size(); i++) {
			SubwayDto dto = modelMapper.map(preResult.get(i), SubwayDto.class);
			dto.setOrd(i);
			result.add(dto);
		}
		StationInfoDto stationInfoDTO = new StationInfoDto();
		stationInfoDTO.setRows(result);
		return stationInfoDTO;
	}
}
