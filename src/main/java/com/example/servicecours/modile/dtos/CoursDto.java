package com.example.servicecours.modile.dtos;

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
}
