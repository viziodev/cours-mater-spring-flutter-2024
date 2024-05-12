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
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.stream.LongStream;

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
        for (int i = 1; i <= 10; i++) {
            Cours cours = coursRepository.findById(Long.valueOf(i)).orElse(null);
            LocalDateTime date = LocalDateTime.of(2024, 4, 8, 5, 9);
            LocalDateTime startTime = LocalDateTime.of(2024, 1, 4, 2, 6); // replace with the desired date and time
            LocalDateTime endTime = LocalDateTime.of(2024, 1, 6, 5, 38); // replace with the desired date and time
            var build = Seance.builder()
                             .date(date)
                             .startTime(startTime)
                             .endTime(endTime)
                             .cours(cours)
                             .status(CoursStatus.STARTED)
                             .build();
            seanceRepository.save(build) ;
        }
    }
}
