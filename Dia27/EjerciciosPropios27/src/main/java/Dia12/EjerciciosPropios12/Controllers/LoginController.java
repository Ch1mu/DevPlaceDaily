package Dia12.EjerciciosPropios12.Controllers;

import Dia12.EjerciciosPropios12.Config.JwtTokenUtil;
import Dia12.EjerciciosPropios12.Models.MyUser;
import Dia12.EjerciciosPropios12.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/token")
public class LoginController {

    @Autowired
    private UserService uS;

    @Autowired
    AuthenticationManager authManager;

    @Autowired
    private JwtTokenUtil jTU;

    @PostMapping()
    public ResponseEntity createToken(@RequestBody MyUser user)
    {
        authManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
        UserDetails uD = uS.loadUserByUsername(user.getUsername());
        String token =jTU.generateToken(uD);
        return ResponseEntity.status(200).body(token);
    }

}
