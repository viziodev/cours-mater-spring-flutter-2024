package com.example.servicecours.services.impl;

import com.example.servicecours.data.entity.Cours;
import com.example.servicecours.data.enums.CoursStatus;
import com.example.servicecours.data.repository.CoursRepository;
import com.example.servicecours.data.repository.projection.CoursAllProjection;
import com.example.servicecours.data.repository.projection.CoursSimpleProjection;
import com.example.servicecours.services.interfaces.ICoursService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CoursService implements ICoursService {
    private final CoursRepository coursRepository;

    @Override
    public List<Cours> getAllCours() {
        return coursRepository.findAll();
    }

    @Override
    public List<CoursAllProjection> getCoursByStatus(CoursStatus courseStatus) {
        return this.coursRepository.findAllByStatus(courseStatus);
    }

    @Override
    public CoursAllProjection getCoursById(Long id) {
        return this
                .coursRepository
                .findCoursById(id)
                ;
    }

    @Override
    public Cours saveCours(Cours course) {
        return this.coursRepository.save(course);
    }

    @Override
    public void deleteCours(Long id) {
        this.coursRepository.deleteById(id);
    }

    @Override
    public Cours updateCours(Long id, Cours course) {
        return this.coursRepository.save(course);
    }
}