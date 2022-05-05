package com.bragadini.matias.controller;


import com.bragadini.matias.model.User;
import com.bragadini.matias.model.Vehicle;
import com.bragadini.matias.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("users")
public class UserController {
    @Autowired
    UserService us;

    //GET ALL VEHICLES
    @GetMapping
    public ArrayList<User> getAllUsers(){
        return us.getAll();
    }


    @GetMapping("/{email}")
    public User getUserByEmail(@PathVariable("email") String email){
        return us.getByEmail(email);
    }

    @PostMapping("/save")
    public void saveUser(@RequestBody User u){
        us.insert(u);
    }

    @PutMapping("/update/{id}")
    public void update(@RequestBody User u) {
        us.update(u);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable("id") long id){
        us.delete(id);
    }


}
