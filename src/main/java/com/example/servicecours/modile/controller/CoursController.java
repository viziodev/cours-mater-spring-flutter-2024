package com.example.servicecours.modile.controller;

import com.example.servicecours.data.entity.Cours;
import com.example.servicecours.data.enums.CoursStatus;
import com.example.servicecours.data.repository.projection.CoursProjection;
import com.example.servicecours.modile.dtos.CoursDto;
import com.example.servicecours.modile.dtos.RestResponse;
import com.example.servicecours.modile.mapper.MapperService;
import com.example.servicecours.services.interfaces.ICoursService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RequestMapping("/cours")
@CrossOrigin(value = "*")
@RestController
@Tag(name = "Cours", description = "Cours API")
public class CoursController {
    private final ICoursService coursService;

    @PostMapping("")
    public Cours saveCourse(Cours cours)  {
        return this.coursService.saveCours(cours);
    }

    @GetMapping()
    public   ResponseEntity<Map<Object, Object>> getCourses()  {
                 List<Cours>  coursList=  this.coursService.getAllCours();
                 List<CoursDto> response=   MapperService.mapToListEntity(coursList,CoursDto.class);
                return new ResponseEntity<>(RestResponse.response(response,HttpStatus.OK), HttpStatus.OK);
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<Map<Object, Object>>  getCoursesByStatus(@PathVariable CoursStatus status)  {
         List<CoursProjection>  coursList=  this.coursService.getCoursByStatus(status);
         List<CoursDto> response=   MapperService.mapToListEntity(coursList,CoursDto.class);
         return new ResponseEntity<>(RestResponse.response(response,HttpStatus.OK), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Cours getCourseById(@PathVariable Long id)  {
        return this.coursService.getCoursById(id);
    }


}
