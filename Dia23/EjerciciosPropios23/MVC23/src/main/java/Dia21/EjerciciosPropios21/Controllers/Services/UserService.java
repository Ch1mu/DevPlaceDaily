package Dia21.EjerciciosPropios21.Controllers.Services;

import Dia21.EjerciciosPropios21.Controllers.Repositories.UserRepository;
import Dia21.EjerciciosPropios21.Models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service

public class UserService {

    @Autowired
    UserRepository uR;

    public void save(User user)
    {
        uR.save(user);
    }

    //GET ALL
    public ArrayList<User> getAll()
    {
        return (ArrayList<User>) uR.findAll();
    }

    //GET BY ID
    public User getByEmail(String email)
    {
        return uR.getByEmail(email);
    }

    //DELETE
    public void delete(long id) {
        uR.delete(id);
    }
}
