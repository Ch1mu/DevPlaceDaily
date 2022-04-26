package com.example.demo.repositories;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;

import com.example.demo.models.InformacionModel;

import org.springframework.data.repository.CrudRepository;

@Repository
public interface InformacionRepository extends CrudRepository<InformacionModel, Long>{
    
    public abstract ArrayList<InformacionModel> findByEdad(Integer edad);

}
