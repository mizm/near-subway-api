package com.example.demo.subway.usecase;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.subway.domain.Point;
import com.example.demo.subway.domain.StationInfoDto;
import com.example.demo.subway.domain.SubwayDto;
import com.example.demo.subway.domain.SubwayInputDto;

@SpringBootTest
class FindNearestSubwayUseCaseTest {

	@Autowired
	FindNearestSubwayUseCase findNearestSubwayUseCase;

	@Test
	void 두개만_나오는_테스트() {
		Point point = new Point(203007.7874, 442807.8308);
		SubwayInputDto subwayInputDto = new SubwayInputDto(0, point);
		StationInfoDto nearestSubway = findNearestSubwayUseCase.findNearestSubway(subwayInputDto);
		List<SubwayDto> rows = nearestSubway.getRows();
		Assertions.assertEquals(2, rows.size());
	}

}
