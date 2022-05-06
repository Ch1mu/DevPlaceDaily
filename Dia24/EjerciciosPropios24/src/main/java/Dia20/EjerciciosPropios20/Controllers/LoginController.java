package Dia20.EjerciciosPropios20.Controllers;

import Dia20.EjerciciosPropios20.Controllers.Services.LoginService;
import Dia20.EjerciciosPropios20.Models.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("")
public class LoginController {

    @Autowired
    LoginService lS;
    @Autowired
    PasswordEncoder pE;

    @GetMapping("/login")
    public String login(Model model)
    {
        Users user = new Users();
        model.addAttribute("user", user);
        return "LoginTemplates/Login";

    }



}
