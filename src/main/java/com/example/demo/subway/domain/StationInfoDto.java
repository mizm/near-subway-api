package com.example.demo.subway.domain;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@XmlRootElement(name = "stationInfo")
@XmlAccessorType(XmlAccessType.FIELD)
public class StationInfoDto {

	@XmlElement(name = "row")
	private List<SubwayDto> rows;

}
