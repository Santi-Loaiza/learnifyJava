package com.example.learnifyJava.repositories;

import com.example.learnifyJava.models.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Integer> {
    //Si tengo consultas personalizadas deben ir en este espacio
}
