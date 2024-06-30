package com.example.servicecours.mobile.dtos;

import java.time.LocalDate;
import java.time.LocalTime;

import com.example.servicecours.data.enums.CoursStatus;

import lombok.Data;

@Data
public class SeanceDto {
    private Long id;
    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;
    private CoursStatus status;
    private String professeur;
    private int duree;
    private String module;

}
