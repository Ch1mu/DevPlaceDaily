package Dia15.EjerciciosManana15.controllers;

import javax.validation.Valid;

import Dia15.EjerciciosManana15.menssage.MessageResponse;
import Dia15.EjerciciosManana15.models.User;
import Dia15.EjerciciosManana15.request.LoginRequest;
import Dia15.EjerciciosManana15.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;




@RestController
@RequestMapping("/api/auth")
public class AuthController {

	@Autowired
	UserService uS;
	
	@Autowired
	PasswordEncoder encoder;
	
	@PostMapping("/login")
	public  ResponseEntity<?> auth(@Valid @RequestBody LoginRequest loginRequest){
		if(uS.emailExists(loginRequest.getEmail()))
		return ResponseEntity.badRequest().body(new MessageResponse("Error: Existing Email"));
		else
			return ResponseEntity.ok().body(new MessageResponse("Logged"));

	
	}
	
	@PostMapping("/register")
	public  ResponseEntity<?> register(@Valid @RequestBody User user){

		if( uS.emailExists(user.getEmail()) )  {
			return ResponseEntity.badRequest().body(new MessageResponse("Error: Existing Email"));
		}
			user.setPassword(encoder.encode(user.getPassword()));
			uS.saveUser(user);
			 return ResponseEntity.ok(new MessageResponse("Registered."));
	}
	
}
