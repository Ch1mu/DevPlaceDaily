package Dia25.Api25.Services;

import Dia25.Api25.Models.User;
import Dia25.Api25.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository uR;

    public void save(User user)
    {
        uR.save(user);
    }

    public List<User> getAll()
    {
        return uR.findAll();
    }
    public User getByEmail(String email)
    {
        return uR.getByEmail(email);
    }
    public User getById(long id)
    {
        return uR.getById(id);
    }
    public void delete(long id)
    {
        uR.deleteById(id);
    }


}
