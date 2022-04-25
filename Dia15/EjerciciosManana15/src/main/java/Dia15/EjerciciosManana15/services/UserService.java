package Dia15.EjerciciosManana15.services;

import Dia15.EjerciciosManana15.repositories.UserRepository;
import Dia15.EjerciciosManana15.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService {
    @Autowired
    UserRepository uR;

    public ArrayList<User> getUsers()
    {
        return (ArrayList<User>) uR.findAll();
    }
    public User saveUser(User user){
        return uR.save(user);
    }
    public ArrayList<User> filterByEmail(String email){
       return uR.filterByEmail(email);
    }
    public boolean deleteByEmail(String email){
        try {
            uR.deleteByEmail(email);
            return  true;
        }
        catch (Exception e)
        {
            return  false;
        }
    }
    public boolean emailExists(String email){
        ArrayList<User> aux = filterByEmail(email);
        if(aux.get(0) == null)
            return false;
        else
            return true;
    }
}
