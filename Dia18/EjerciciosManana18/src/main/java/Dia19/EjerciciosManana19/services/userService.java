package Dia19.EjerciciosManana19.services;

import Dia19.EjerciciosManana19.models.User;
import Dia19.EjerciciosManana19.repositories.userRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class userService {

    @Autowired
    userRepo uR;

    public void saveUser(User user)
    {
        uR.save(user);
    }
    public ArrayList<User> getUsers()
    {
        return (ArrayList<User>) uR.findAll();
    }
    public User getUserById(long id)
    {
        return  uR.getUserById(id);
    }
    public User editUser(User user, long id)
    {
        user.setId(id);
        return  uR.save(user);
    }
    public void deleteUser(long id)
    {
        uR.deleteById(id);
    }
}
