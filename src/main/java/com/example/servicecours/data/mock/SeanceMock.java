package com.example.servicecours.data.mock;


import com.example.servicecours.data.entity.Cours;
import com.example.servicecours.data.entity.Seance;
import com.example.servicecours.data.enums.CoursStatus;
import com.example.servicecours.data.repository.CoursRepository;
import com.example.servicecours.data.repository.SeanceRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalTime;


@Component
@Builder
@RequiredArgsConstructor
@Order(3)
public class SeanceMock implements CommandLineRunner  {
    private final CoursRepository coursRepository ;
    private final SeanceRepository seanceRepository ;

    @Transactional
    @Override
    public void run(String... args) throws Exception {
        for (int i = 20; i <= 31; i++) {
            Cours cours = coursRepository.findById(Long.valueOf(i-19)).orElse(null);
            LocalDate date = i%2==0? LocalDate.of(2024, 5, i ):LocalDate.now();
            LocalTime startTime = LocalTime.of(i-10,0);
            LocalTime endTime = LocalTime.of(i+2-10,0);
            var build = Seance.builder()
                             .date(date)
                             .startTime(startTime)
                             .endTime(endTime)
                             
                             .cours(cours)
                             .status(i%2==0?CoursStatus.STARTED:CoursStatus.PLANNED)
                             .build();
            seanceRepository.save(build) ;
        }
    }
}
