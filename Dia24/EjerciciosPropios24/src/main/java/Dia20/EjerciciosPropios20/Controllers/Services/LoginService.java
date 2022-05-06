package Dia20.EjerciciosPropios20.Controllers.Services;

import Dia20.EjerciciosPropios20.Controllers.Repositories.LoginRepository;
import Dia20.EjerciciosPropios20.Models.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    LoginRepository lR;

    public Users byUsername(String username){
        return lR.findByUsername(username);
    }
}
