package com.example.demo.board.infra;

import com.example.demo.board.domain.Subway;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SubwayRepository extends JpaRepository<Subway, Integer> {
   //Camel case로 알아서 맞추어서 할 수 있음.
    List<Subway> findAllByXBetweenAndYBetween(double minX, double maxX, double minY, double maxY);

}
