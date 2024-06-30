package com.example.servicecours.data.repository;

import com.example.servicecours.data.entity.Cours;
import com.example.servicecours.data.entity.Seance;
import com.example.servicecours.data.enums.CoursStatus;
import com.example.servicecours.data.repository.projection.SeanceProjection;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface SeanceRepository extends JpaRepository<Seance, Long> {
    List<Seance> findAllByStatus(CoursStatus courseStatus);
    List<SeanceProjection> findAllByDateAndStatus(LocalDate date,CoursStatus courseStatus);
    List<SeanceProjection>  findAllByCours(Cours cours);
}
