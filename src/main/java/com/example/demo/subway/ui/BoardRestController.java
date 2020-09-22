package com.example.demo.subway.ui;

import com.example.demo.subway.domain.SubwayInputDTO;
import com.example.demo.subway.infra.SubwayRepository;
import com.example.demo.subway.usecase.FindNearestSubwayUseCase;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class BoardRestController {

    final private SubwayRepository subwayRepository;
    final private ModelMapper modelMapper;
    final private FindNearestSubwayUseCase findNearestSubwayUseCase;


    @Autowired
    public BoardRestController(SubwayRepository subwayRepository, ModelMapper modelMapper, FindNearestSubwayUseCase findNearestSubwayUseCase) {
        this.subwayRepository = subwayRepository;
        this.modelMapper = modelMapper;
        this.findNearestSubwayUseCase = findNearestSubwayUseCase;
    }

    //이미 존재헀던 api가 get 방식이므로 어쩔수 없이 get 방식으로
    //mapping에는 풀 경로를 다 적는게 좋음
    @GetMapping(value = "/api/v1/subway/near", produces = MediaType.APPLICATION_XML_VALUE)
        ResponseEntity nearSubways(SubwayInputDTO subwayInputDTO){
        return new ResponseEntity<>(findNearestSubwayUseCase.findNearestSubway(subwayInputDTO), HttpStatus.OK);
    }

    @ExceptionHandler(BadRequestException.class)
    ResponseEntity badRequestExceptionHandler(BadRequestException e)
    {
        ErrorResponse errorResponse = new ErrorResponse("잘못된 요청", e.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
