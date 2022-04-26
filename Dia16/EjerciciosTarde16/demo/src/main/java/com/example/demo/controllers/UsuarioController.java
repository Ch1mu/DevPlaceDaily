package com.example.demo.controllers;
import com.example.demo.services.UsuarioService;
import java.util.ArrayList;
import java.util.Optional;



import com.example.demo.models.*;
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
@RequestMapping("/usuario")

public class UsuarioController {

  
@Autowired
UsuarioService usuarioService;

@GetMapping()
public ArrayList<UsuarioModel> obtenerUsuarios()
{
    return usuarioService.obtenerUsuarios();
}

@PostMapping()
public UsuarioModel guardarUsuario(@RequestBody UsuarioModel usuario)
{
    return this.usuarioService.guardarUsuario(usuario);
}
    @PostMapping("/edit/{id}")
    public UsuarioModel guardarUsuario(@RequestBody UsuarioModel usuario, @PathVariable("id") Long id )
    {
        return this.usuarioService.editarUsuario(usuario, id);
    }


@GetMapping("/{id}")
public Optional<UsuarioModel> obtenerUsuarioPorId(@PathVariable("id") Long id)
{
    return this.usuarioService.obtenerPorId(id);
}

@GetMapping(path = "/query")
public ArrayList<UsuarioModel> obtenerUsuarioPorPrioridad(@RequestParam("prioridad") Integer prioridad)
{
    return this.usuarioService.oboterPorPrioridad(prioridad);
}


@DeleteMapping (path = "/{id}")
public String eliminarPorId(@PathVariable("id") Long id)
{
    boolean ok = this.usuarioService.elinminarUsuario(id);

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
