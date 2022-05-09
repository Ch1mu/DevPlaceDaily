package Dia25.MVC25.Controllers;

import Dia25.MVC25.Controllers.MicroServices.Adapters.UserAdapter;
import Dia25.MVC25.Models.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

@Controller
@RequestMapping("/login")
public class LoginController {


    @GetMapping
    public String login()
    {

        return "LoginTemplates/login";
    }
}
