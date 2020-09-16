package com.example.demo.board.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "API_SUBWAY_POINT")
public class Subway{

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
        return Math.sqrt(Math.pow((x1-this.x),2) + Math.pow((y1-this.y),2));
    }

}
