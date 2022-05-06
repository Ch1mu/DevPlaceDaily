package com.example.EjerciciosManana18.controller.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.EjerciciosManana18.model.Subject;

@Repository
public interface SubjectRepository extends JpaRepository<Subject,Long> {

}
