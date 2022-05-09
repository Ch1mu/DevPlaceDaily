package com.example.EjerciciosManana18.controller.api;

import com.example.EjerciciosManana18.controller.service.UserService;
import com.example.EjerciciosManana18.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/users")
public class UserApiController {

	@Autowired
	private UserService us;
	
	@GetMapping(produces = { "application/json", "application/xml" })
	public List<User> getAll(Model model) {
		return us.getAll();

	}
		

	
	@PostMapping("/createUser")
	public ResponseEntity insertUser(@RequestBody User u) {
		us.insertUser(u);
		return ResponseEntity.ok().body("Success.");
	}
	

	
	@PutMapping("/update/{id}")
	public ResponseEntity updateUser(@RequestBody User u, @PathVariable("id") long id) {
		us.updateUser(u);
		return ResponseEntity.ok().body("Success.");
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity deleteUser(@PathVariable("id") long id ){
		us.deleteUser(id);
		return ResponseEntity.ok().body("Success.");
	}
}
