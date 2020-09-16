package com.example.demo.board.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;


@Getter
@Setter
@XmlRootElement(name = "row")
@XmlAccessorType(XmlAccessType.FIELD)
public class SubwayDTO {

    private String statnId;
    private String statnNm;
    private String subwayId;
    private String subwayNm;
    private double x;
    private double y;
    private int ord;

}
