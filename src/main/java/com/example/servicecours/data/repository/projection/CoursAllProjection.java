package com.example.servicecours.data.repository.projection;


public interface CoursAllProjection extends CoursSimpleProjection {
    Integer getTotalHeure();
    Integer getTotalHeurePlanifier();
    Integer getTotalHeureRealiser();

}
