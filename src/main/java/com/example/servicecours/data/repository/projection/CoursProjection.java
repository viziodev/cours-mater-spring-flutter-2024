package com.example.servicecours.data.repository.projection;

import com.example.servicecours.data.enums.CoursStatus;

public interface CoursProjection {
    Long getId();
    String getModule();
    String getProfessor();
    CoursStatus getStatus();
    String getIcon();

}
