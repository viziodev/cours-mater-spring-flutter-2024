package com.example.servicecours.data.repository.projection;

import com.example.servicecours.data.enums.CoursStatus;

public interface CoursSimpleProjection {
    Long getId();
    String getModule();
    String getProfessor();
    CoursStatus getStatus();
    String getIcon();
    ClassRomProjection getClassRoom();
}
