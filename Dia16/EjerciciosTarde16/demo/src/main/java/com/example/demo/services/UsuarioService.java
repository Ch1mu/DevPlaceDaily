package com.example.demo.services;

import java.util.ArrayList;
import java.util.Optional;

import com.example.demo.models.UsuarioModel;
import com.example.demo.repositories.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    @Autowired
    UsuarioRepository usuarioRepository;

    public ArrayList<UsuarioModel> obtenerUsuarios()
    {
        return (ArrayList<UsuarioModel>)usuarioRepository.findAll();
    }

    public UsuarioModel guardarUsuario(UsuarioModel usuario)
    {
        return usuarioRepository.save(usuario);
    }
    public Optional<UsuarioModel> obtenerPorId(Long id)
    {
        return usuarioRepository.findById(id);
        
    }
    public ArrayList<UsuarioModel> oboterPorPrioridad(Integer prioridad)
    {
        return usuarioRepository.findByPrioridad(prioridad);
    }
    public  UsuarioModel editarUsuario(UsuarioModel user, Long id)
    {
        user.setId(id);
        return  usuarioRepository.save(user);
    }
    public boolean elinminarUsuario(Long id)
    {
        try {
            usuarioRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
       
    }




}
