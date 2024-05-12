package com.example.servicecours.services.interfaces;

import com.example.servicecours.data.entity.Seance;
import com.example.servicecours.data.enums.CoursStatus;

import java.util.List;

public interface ISeanceService {
    List<Seance> getSeances();
    List<Seance> getSeancesByStatus(CoursStatus courseStatus);
    Seance getSeanceById(Long id);
    Seance saveSeance(Seance seance);
    void deleteSeance(Long id);
    Seance updateSeance(Long id, Seance seance);
}
