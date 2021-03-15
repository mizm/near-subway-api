package com.example.demo.subway.usecase;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.demo.subway.domain.StationInfoDto;
import com.example.demo.subway.domain.Subway;
import com.example.demo.subway.domain.SubwayDto;
import com.example.demo.subway.domain.SubwayInputDto;
import com.example.demo.subway.infra.SubwayRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class FindNearestSubwayUseCase implements FindNearestSubwayInterface {

	private SubwayRepository subwayRepository;
	private ModelMapper modelMapper;

	public FindNearestSubwayUseCase(SubwayRepository subwayRepository, ModelMapper modelMapper) {
		this.subwayRepository = subwayRepository;
		this.modelMapper = modelMapper;
	}

	@Override
	public StationInfoDto findNearestSubway(SubwayInputDto subwayInputDto) {
		List<Subway> preResult = new ArrayList<Subway>();
		preResult = subwayRepository.findAllByXBetweenAndYBetween(
			subwayInputDto.getMinX(),
			subwayInputDto.getMaxX(),
			subwayInputDto.getMinY(),
			subwayInputDto.getMaxY()
		);
		double x = subwayInputDto.getX();
		double y = subwayInputDto.getY();
		preResult.sort(new Comparator<Subway>() {
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
		StationInfoDto stationInfoDto = new StationInfoDto();
		stationInfoDto.setRows(result);
		return stationInfoDto;
	}
}
