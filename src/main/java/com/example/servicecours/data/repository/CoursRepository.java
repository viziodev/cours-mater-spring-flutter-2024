package com.example.servicecours.data.repository;

import com.example.servicecours.data.entity.Cours;
import com.example.servicecours.data.enums.CoursStatus;
import com.example.servicecours.data.repository.projection.CoursAllProjection;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CoursRepository extends JpaRepository<Cours, Long> {
    List<CoursAllProjection> findAllByStatus(CoursStatus courseStatus);
     CoursAllProjection  findCoursById(Long id);
  
}
