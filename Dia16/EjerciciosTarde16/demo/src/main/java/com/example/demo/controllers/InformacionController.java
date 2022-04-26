package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.Optional;

import com.example.demo.models.InformacionModel;
import com.example.demo.models.UsuarioModel;
import com.example.demo.services.InformacionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/informacion")

public class InformacionController {

    @Autowired
InformacionService informacionService;


@GetMapping()
public ArrayList<InformacionModel> obtenerInfo()
{
    return informacionService.obtenerInfo();
}
@GetMapping(path = "/edad")
public ArrayList<InformacionModel> obtenerInfoPorEdad(@RequestParam("edad") Integer edad)
{
    return this.informacionService.findByEdad(edad);
}
@PostMapping()
public InformacionModel guardarUsuario(@RequestBody InformacionModel info)
{
    return this.informacionService.guardarInfo(info);
}

@GetMapping(path = "/{id}")
public Optional<InformacionModel> obtenerInfoPorId(@PathVariable("id") Long id)
{
    return this.informacionService.obtenerPorId(id);
}
    @PostMapping("/edit/{id}")
    public InformacionModel guardarInfo(@RequestBody InformacionModel info, @PathVariable("id") Long id )
    {
        return this.informacionService.editarInfo(info, id);
    }
@DeleteMapping (path = "/{id}")
public String eliminarPorId(@PathVariable("id") Long id)
{
    boolean ok = this.informacionService.eliminarInfo(id);

   if(ok)
   {
       return "Se elimino correctamente el usuario" + id;
   }
   else
   {
    return " No se pudo eliminar el usuario" + id;
   }
}
}
