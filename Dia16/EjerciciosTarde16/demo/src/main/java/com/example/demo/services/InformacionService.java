package com.example.demo.services;

import java.util.ArrayList;
import java.util.Optional;

import com.example.demo.models.InformacionModel;
import com.example.demo.models.UsuarioModel;
import com.example.demo.repositories.InformacionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InformacionService {
    
    @Autowired
    InformacionRepository informacionRepository;

    public ArrayList<InformacionModel> obtenerInfo()
    {
        return (ArrayList<InformacionModel>)informacionRepository.findAll();
    }

    public ArrayList<InformacionModel> findByEdad(Integer edad)
    {
        return informacionRepository.findByEdad(edad);
    }
    public InformacionModel guardarInfo(InformacionModel info)
    {
        return informacionRepository.save(info);
    }
    public Optional<InformacionModel> obtenerPorId(Long id)
    {
        return informacionRepository.findById(id);
      
    }
    public InformacionModel editarInfo(InformacionModel info, Long id)
    {
        info.setId(id);
        return  informacionRepository.save(info);
    }
    public boolean eliminarInfo(Long id)
    {
        try {
            informacionRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
       
    }
}
