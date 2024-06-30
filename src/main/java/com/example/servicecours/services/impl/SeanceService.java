package com.example.servicecours.services.impl;

import com.example.servicecours.data.entity.Cours;
import com.example.servicecours.data.entity.Seance;
import com.example.servicecours.data.enums.CoursStatus;
import com.example.servicecours.data.repository.CoursRepository;
import com.example.servicecours.data.repository.SeanceRepository;
import com.example.servicecours.data.repository.projection.SeanceProjection;
import com.example.servicecours.services.interfaces.ISeanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SeanceService implements ISeanceService {
    private final SeanceRepository seanceRepository;
    private final CoursRepository coursRepository;

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

    @Override
    public   List<SeanceProjection> getSeanceByDate(LocalDate date,CoursStatus status) {
        return seanceRepository.findAllByDateAndStatus(date,status);
    }

    @Override
    public List<SeanceProjection> getSeancesByCours(Long coursId) {
       Optional<Cours> cours= coursRepository.findById(coursId);
       if (!cours.isPresent()) {
           return null;
        }
       return seanceRepository.findAllByCours(cours.get());
    }
}
