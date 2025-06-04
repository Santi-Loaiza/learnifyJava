package com.example.learnifyJava.controllers;

import com.example.learnifyJava.models.Grade;
import com.example.learnifyJava.models.Teacher;
import com.example.learnifyJava.services.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ grados")
public class GradeController {

    @Autowired
    GradeService service;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Grade dataSentByClient){
        try{
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(this.service.saveGrade(dataSentByClient));
        } catch(Exception e){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }


    @GetMapping
    public ResponseEntity<?> searchEverything(){
        try{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.service.listGrades());
        }catch(Exception errorAPI){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(errorAPI.getMessage());
        }
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> searchById(@PathVariable Integer id){
        try{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.service.searchGradeById(id));
        }catch(Exception errorAPI){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(errorAPI.getMessage());
        }
    }


    @PutMapping("/{id}")
    public ResponseEntity<?> modify(@PathVariable Integer id, @RequestBody Grade data){
        try{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.service.modifyGrader(id, data));
        }catch(Exception errorAPI){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(errorAPI.getMessage());
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        try{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.service.deleteGrade(id));
        }catch(Exception errorAPI){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(errorAPI.getMessage());
        }
    }
}
