package com.example.demo.board.usecase;

import com.example.demo.board.domain.StationInfoDTO;
import com.example.demo.board.domain.Subway;
import com.example.demo.board.domain.SubwayDTO;
import com.example.demo.board.domain.SubwayInputDTO;
import com.example.demo.board.infra.SubwayRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

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
    public StationInfoDTO findNearestSubway(SubwayInputDTO subwayInputDTO) {
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
                if (s1.getDistance(x,y) < s2.getDistance(x,y)) {
                    return -1;
                } else {
                    return 1;
                }
            }
        });
        List<SubwayDTO> result = new ArrayList<SubwayDTO>();
        for(int i = 0; i < preResult.size(); i++) {
            SubwayDTO dto = modelMapper.map(preResult.get(i),SubwayDTO.class);
            dto.setOrd(i);
            result.add(dto);
        }
        StationInfoDTO stationInfoDTO = new StationInfoDTO();
        stationInfoDTO.setRows(result);
        return stationInfoDTO;
    }
}
