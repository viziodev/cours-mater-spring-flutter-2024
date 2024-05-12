package com.example.servicecours.data.entity;

import lombok.*;

import jakarta.persistence.*;
import java.util.Set;

@Setter
@Getter
@Entity
@Table(name = "class_room")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClassRom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String nom ;
    private String matiere ;
    private String niveau ;

    @OneToMany(mappedBy = "classRoom")
    private Set<Cours> cours;
}
