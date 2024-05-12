package com.example.servicecours.data.entity;

import com.example.servicecours.data.enums.CoursStatus;
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

    @OneToMany(mappedBy = "cours")
    private Set<Seance> seances;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private ClassRom classRoom;

    @Enumerated(EnumType.STRING)
    private CoursStatus status;

    @Column(name = "icon", nullable = false)
    private String icon;
}
