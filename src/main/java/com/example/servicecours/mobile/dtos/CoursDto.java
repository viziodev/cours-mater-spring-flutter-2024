package com.example.servicecours.mobile.dtos;

import com.example.servicecours.data.enums.CoursStatus;

import lombok.Data;



import java.io.Serializable;

@Data
public class CoursDto implements Serializable {
    Long id;
    String module;
    String professor;
    CoursStatus status;
    String icon;
    private Integer totalHeure;
    private Integer totalHeurePlanifier;
    private Integer totalHeureRealiser;
}
