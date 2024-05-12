package com.example.servicecours.data.repository;

import com.example.servicecours.data.entity.ClassRom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ClassRoomRepository extends JpaRepository<ClassRom, Long>, JpaSpecificationExecutor<ClassRom> {
}
