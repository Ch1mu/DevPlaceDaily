package com.bragadini.matias.services;

import com.bragadini.matias.model.User;
import com.bragadini.matias.model.Vehicle;
import com.bragadini.matias.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository ur;

    public ArrayList<User> getAll(){
        return (ArrayList<User>) ur.findAll();
    }


    public void insert(User u){
        ur.save(u);
    }

    public void delete(long id){
        ur.deleteById(id);
    }

    public boolean update(User u){
        if(ur.existsById(u.getId())){
            ur.save(u);
            return true;
        } else return false;
    }

    public User getByEmail (String email){
        User user = ur.getByEmail(email);
        return user;
    }

}
