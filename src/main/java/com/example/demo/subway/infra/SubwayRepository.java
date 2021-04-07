package com.example.demo.subway.infra;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.subway.domain.Subway;

public interface SubwayRepository extends JpaRepository<Subway, Integer> {
	//Camel case로 알아서 맞추어서 할 수 있음.
	List<Subway> findAllByPointXBetweenAndPointYBetween(double minX, double maxX, double minY, double maxY);

}
