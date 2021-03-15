package com.example.demo.subway.usecase;

import com.example.demo.subway.domain.StationInfoDto;
import com.example.demo.subway.domain.SubwayInputDto;

public interface FindNearestSubwayInterface {
	StationInfoDto findNearestSubway(SubwayInputDto subwayInputDto);
}
