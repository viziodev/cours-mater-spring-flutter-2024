package com.example.servicecours.data.repository.projection;

import java.time.LocalDate;
import java.time.LocalTime;

import com.example.servicecours.data.enums.CoursStatus;

public interface SeanceProjection {
    Long getId();
    LocalDate getDate();
    LocalTime getStartTime();
    LocalTime getEndTime();
    CoursStatus getStatus();
    CoursAllProjection getCours();
}
