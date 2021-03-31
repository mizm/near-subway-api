package com.example.demo.subway.domain;

import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter
public class Point {
	private double x;
	private double y;
}
