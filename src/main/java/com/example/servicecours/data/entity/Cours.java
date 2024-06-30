package com.example.servicecours.data.entity;

import com.example.servicecours.data.enums.CoursStatus;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.*;

import jakarta.persistence.*;
import java.util.Set;

@Setter
@Getter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cours")
public class Cours {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "module", nullable = false)
    private String module;

    @Column(name = "professor", nullable = false)
    private String professor;

    @JsonManagedReference
    @OneToMany(mappedBy = "cours")
    private Set<Seance> seances;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private ClassRom classRoom;

    @Enumerated(EnumType.STRING)
    private CoursStatus status;

    @Column(name = "icon", nullable = false)
    private String icon;

    @Column(name = "total_heure", nullable = false)
    private Integer totalHeure;
    @Column(name = "total_heure_planifier", nullable = true)
    private Integer totalHeurePlanifier;
    @Column(name = "total_heure_realiser", nullable = true)
    private Integer totalHeureRealiser;
}
