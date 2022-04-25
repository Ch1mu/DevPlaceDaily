package Dia15.EjerciciosManana15.controllers;

import Dia15.EjerciciosManana15.services.UserService;
import Dia15.EjerciciosManana15.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController
public class UserController {
    @Autowired
    UserService uS;
    @GetMapping
    public ArrayList<User> getAllUsers() {
        return uS.getUsers();
    }
    @PostMapping
    public ResponseEntity<?> saveUser(@Valid @RequestBody User user)
    {
        if(!uS.emailExists(user.getEmail()))
        {
            uS.saveUser(user);
            return ResponseEntity.ok().body("Added");
        }
        else {
            return ResponseEntity.badRequest().body("Email Already in use");
        }
    }
}
