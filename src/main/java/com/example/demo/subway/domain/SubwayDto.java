package com.example.demo.subway.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("checkstyle:MemberName")
@Getter
@Setter
@XmlRootElement(name = "row")
@XmlAccessorType(XmlAccessType.FIELD)
public class SubwayDto {
	private String statnId;
	private String statnNm;
	private String subwayId;
	private String subwayNm;
	private Point point;
	private int ord;
}
