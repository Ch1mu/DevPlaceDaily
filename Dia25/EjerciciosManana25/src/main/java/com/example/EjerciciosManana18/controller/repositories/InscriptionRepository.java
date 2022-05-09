package com.example.EjerciciosManana18.controller.repositories;

import org.hibernate.tool.schema.internal.IndividuallySchemaMigratorImpl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.EjerciciosManana18.model.Inscription;

@Repository
public interface InscriptionRepository extends JpaRepository<Inscription,Long>{
    @Query(value = "select * from inscription i where (i.student_dni = :dni and i.subject_code = :code)", nativeQuery = true)
    public Inscription checkins(long dni, long code);

}
