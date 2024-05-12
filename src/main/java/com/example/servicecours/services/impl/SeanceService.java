package com.example.servicecours.services.impl;

import com.example.servicecours.data.entity.Seance;
import com.example.servicecours.data.enums.CoursStatus;
import com.example.servicecours.data.repository.SeanceRepository;
import com.example.servicecours.services.interfaces.ISeanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SeanceService implements ISeanceService {
    private final SeanceRepository seanceRepository;

    @Override
    public List<Seance> getSeances() {
        return seanceRepository.findAll();
    }

    @Override
    public List<Seance> getSeancesByStatus(CoursStatus courseStatus) {
        return seanceRepository.findAllByStatus(courseStatus);
    }

    @Override
    public Seance getSeanceById(Long id) {
        return seanceRepository.findById(id).orElseThrow(() -> new RuntimeException("Seance not found"));
    }

    @Override
    public Seance saveSeance(Seance seance) {
        return seanceRepository.save(seance);
    }

    @Override
    public void deleteSeance(Long id) {
        seanceRepository.deleteById(id);
    }

    @Override
    public Seance updateSeance(Long id, Seance seance) {
        return seanceRepository.save(seance);
    }
}
