package Dia25.Api25.Services;

import Dia25.Api25.Models.Roles;

import Dia25.Api25.Repositories.RolesRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolesService {

    @Autowired
    UserService uS;
    @Autowired
    private RolesRepository uR;

    public void save(Roles user)
    {
        uR.save(user);
    }

    public boolean isAdmin(long id) {
        if (uS.getById(id).getRole() == 3)
        {
            return  true;
        }
        else
        {
            return false;
        }

    }
    public List<Roles> getAll()
    {
        return uR.findAll();
    }
    public Roles getById(long id)
    {
        return uR.getById(id);
    }
    public void delete(long id)
    {
        uR.deleteById(id);
    }


}
