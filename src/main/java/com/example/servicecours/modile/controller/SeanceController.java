package com.example.servicecours.modile.controller;

import com.example.servicecours.data.entity.Seance;
import com.example.servicecours.data.enums.CoursStatus;
import com.example.servicecours.services.interfaces.ISeanceService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RequestMapping("/seances")
@RestController
@Tag(name = "Seance", description = "Seance API")
public class SeanceController {

    private final ISeanceService seanceService;

    @PostMapping()
    public Seance saveSeance(Seance seance)  {
        return this.seanceService.saveSeance(seance);
    }

    @GetMapping()
    public List<Seance> getSeances()  {
        return this.seanceService.getSeances();
    }

    @GetMapping("/status/{status}")
    public List<Seance> getSeancesByStatus(@PathVariable CoursStatus status)  {
        return this.seanceService.getSeancesByStatus(status);
    }

    @GetMapping("/{id}")
    public Seance getSeanceById(@PathVariable Long id)  {
        return this.seanceService.getSeanceById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteSeance(@PathVariable Long id)  {
        this.seanceService.deleteSeance(id);
    }

}
