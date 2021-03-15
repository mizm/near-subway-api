package com.example.demo.subway.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "API_SUBWAY_POINT")
public class Subway {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String statnId;
	private String statnNm;
	private String subwayId;
	private String subwayNm;

	private double x;
	private double y;

	public double getDistance(double x1, double y1) {
		return Math.sqrt(Math.pow((x1 - this.x), 2) + Math.pow((y1 - this.y), 2));
	}

}
