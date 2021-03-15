package com.example.demo.subway.ui;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.subway.domain.SubwayInputDto;
import com.example.demo.subway.infra.SubwayRepository;
import com.example.demo.subway.usecase.FindNearestSubwayUseCase;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class BoardRestController {

	private SubwayRepository subwayRepository;
	private ModelMapper modelMapper;
	private FindNearestSubwayUseCase findNearestSubwayUseCase;

	public BoardRestController(SubwayRepository subwayRepository, ModelMapper modelMapper,
		FindNearestSubwayUseCase findNearestSubwayUseCase) {
		this.subwayRepository = subwayRepository;
		this.modelMapper = modelMapper;
		this.findNearestSubwayUseCase = findNearestSubwayUseCase;
	}

	//이미 존재헀던 api가 get 방식이므로 어쩔수 없이 get 방식으로
	//mapping에는 풀 경로를 다 적는게 좋음
	@GetMapping(value = "/api/v1/subway/near", produces = MediaType.APPLICATION_XML_VALUE)
	ResponseEntity nearSubways(SubwayInputDto subwayInputDto) {
		return new ResponseEntity<>(findNearestSubwayUseCase.findNearestSubway(subwayInputDto), HttpStatus.OK);
	}

	@ExceptionHandler(BadRequestException.class)
	ResponseEntity badRequestExceptionHandler(BadRequestException badRequestException) {
		ErrorResponse errorResponse = new ErrorResponse("잘못된 요청", badRequestException.getMessage());
		return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
	}
}
