package com.example.EjerciciosManana18.controller.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.EjerciciosManana18.model.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long>{
    Page<User> findAll(Pageable ammount);
}
