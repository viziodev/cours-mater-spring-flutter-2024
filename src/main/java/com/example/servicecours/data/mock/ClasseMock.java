package com.example.servicecours.data.mock;

import com.example.servicecours.data.entity.ClassRom;
import com.example.servicecours.data.repository.ClassRoomRepository;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Builder
@RequiredArgsConstructor
@Order(1)
public class ClasseMock implements CommandLineRunner {
    private final ClassRoomRepository classRoomRepository;
    @Override
    public void run(String... args) throws Exception {
        for (int i = 1; i <= 10; i++) {
            var build = ClassRom.builder()
                    .matiere("Matiere " + i)
                    .niveau("Niveau " + i)
                    .nom("Classe " + i)
                    .build();
            classRoomRepository.save(build) ;
        }
    }
}
