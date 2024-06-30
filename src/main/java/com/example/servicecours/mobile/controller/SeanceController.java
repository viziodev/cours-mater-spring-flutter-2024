package com.example.servicecours.mobile.controller;

import com.example.servicecours.data.entity.Cours;
import com.example.servicecours.data.entity.Seance;
import com.example.servicecours.data.enums.CoursStatus;
import com.example.servicecours.data.repository.projection.SeanceProjection;
import com.example.servicecours.mobile.dtos.CoursDto;
import com.example.servicecours.mobile.dtos.RestResponse;
import com.example.servicecours.mobile.dtos.SeanceDto;
import com.example.servicecours.mobile.mapper.MapperService;
import com.example.servicecours.services.interfaces.ISeanceService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;


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
    public ResponseEntity<Map<Object, Object>>getSeances()  {
        List<Seance>  seanceList= this.seanceService.getSeances();
        List<SeanceDto> response=   MapperService.mapToListEntity(seanceList,SeanceDto.class);
        return new ResponseEntity<>(RestResponse.response(response,HttpStatus.OK), HttpStatus.OK); 
    }

    @GetMapping("/status/{status}")
    public List<Seance> getSeancesByStatus(@PathVariable CoursStatus status)  {
        return this.seanceService.getSeancesByStatus(status);
    }
    @GetMapping("/date")
    public ResponseEntity<Map<Object, Object>> getSeancesByDate()  {
          List<SeanceProjection>  seanceList= this.seanceService.getSeanceByDate(LocalDate.now(),CoursStatus.PLANNED);
         // List<SeanceDto> response=   MapperService.mapToListEntity(seanceList,SeanceDto.class);
          return new ResponseEntity<>(RestResponse.response(seanceList,HttpStatus.OK), HttpStatus.OK); 
    }
    @GetMapping("/{id}")
    public Seance getSeanceById(@PathVariable Long id)  {
        return this.seanceService.getSeanceById(id);
    }

    @GetMapping("/cours/{id}")
    public ResponseEntity<Map<Object, Object>> getSeanceByCours(@PathVariable Long id)  {
        List<SeanceProjection>  seanceList= this.seanceService.getSeancesByCours(id);
      return new ResponseEntity<>(RestResponse.response(seanceList,HttpStatus.OK), HttpStatus.OK); 
    }

    @DeleteMapping("/{id}")
    public void deleteSeance(@PathVariable Long id)  {
        this.seanceService.deleteSeance(id);
    }

}
