package com.example.EjerciciosManana18.controller.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.EjerciciosManana18.model.Student;

import java.util.ArrayList;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query(value = "select * from student s order by s.name asc", countQuery = "SELECT count(*) FROM student", nativeQuery = true)
    public Page<Student> ascendant(Pageable ammount);
    @Query(value = "select * from student s order by s.name desc",countQuery = "SELECT count(*) FROM student", nativeQuery = true)
    public Page<Student> descendant(Pageable ammount);

    @Query(value = "select * from student s where s.name = :name", nativeQuery = true)
    public ArrayList<Student>byName(@Param("name") String name);

    @Query(value = "select * from student s where s.lastname = :lastname", nativeQuery = true)
    public ArrayList<Student> byLastname(@Param("lastname") String lastname);
}
