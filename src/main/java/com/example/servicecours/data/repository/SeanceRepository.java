package com.example.servicecours.data.repository;

import com.example.servicecours.data.entity.Seance;
import com.example.servicecours.data.enums.CoursStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SeanceRepository extends JpaRepository<Seance, Long> {
    List<Seance> findAllByStatus(CoursStatus courseStatus);
}
