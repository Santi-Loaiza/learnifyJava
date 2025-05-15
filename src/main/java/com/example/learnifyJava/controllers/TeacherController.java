package com.example.learnifyJava.controllers;

import com.example.learnifyJava.models.Teacher;
import com.example.learnifyJava.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/docentes")
public class TeacherController {

    @Autowired
    TeacherService service;

    //guardar
    @PostMapping
    public ResponseEntity<?> save(@RequestBody Teacher dataSentByClient){
    try{
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(this.service.saveTeacher(dataSentByClient));
    } catch(Exception e){
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(e.getMessage());
    }
    }

    //buscarTodos

    //buscarPorId

    //modificar

    //eliminar
}
