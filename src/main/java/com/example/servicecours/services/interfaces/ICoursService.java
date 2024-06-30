package com.example.servicecours.services.interfaces;

import com.example.servicecours.data.entity.Cours;
import com.example.servicecours.data.enums.CoursStatus;
import com.example.servicecours.data.repository.projection.CoursAllProjection;
import com.example.servicecours.data.repository.projection.CoursSimpleProjection;

import java.util.List;

public interface ICoursService {
    List<Cours> getAllCours();
    List<CoursAllProjection> getCoursByStatus(CoursStatus courseStatus);
    CoursAllProjection getCoursById(Long id);
    Cours saveCours(Cours course);
    void deleteCours(Long id);
    Cours updateCours(Long id, Cours course);
}
