package net.DevPlaceManana.springboot.controller;

import java.util.List;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.DevPlaceManana.springboot.entity.User;
import net.DevPlaceManana.springboot.exception.ResourceNotFoundException;
import net.DevPlaceManana.springboot.repository.UserRepository;

@RestController
@RequestMapping("/api/users")
public class UserController {
	@Autowired
	private UserRepository userRepository;


	@ApiOperation(value = "list Users", notes = "List all Users")
	@ApiResponses(value ={@ApiResponse( code = 200, message = "ok, list"), @ApiResponse(code = 400, message = "Empty"), @ApiResponse(code=500, message = "Server Error")})
	@GetMapping
	public List<User> getAllUsers() {
		return this.userRepository.findAll();
	}

	@ApiOperation(value = "list Users", notes = "List user with matching id")
	@ApiResponses(value ={@ApiResponse( code = 200, message = "ok, list"), @ApiResponse(code = 400, message = "Invalid id"), @ApiResponse(code=500, message = "Server Error")})
	@GetMapping("/{id}")
	public User getUserById(@PathVariable (value = "id") long userId) {
		return this.userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found with id :" + userId));
	}

	@ApiOperation(value = "Post User", notes = "Post an user")
	@ApiResponses(value ={@ApiResponse( code = 200, message = "Exit"), @ApiResponse(code = 400, message = "Empty"), @ApiResponse(code=500, message = "Server Error")})
	@PostMapping
	public User createUser(@RequestBody User user) {
		return this.userRepository.save(user);
	}


	@ApiOperation(value = "Update  User", notes = "Update user with matching id")
	@ApiResponses(value ={@ApiResponse( code = 200, message = "ok, list"), @ApiResponse(code = 400, message = "Invalid Id"), @ApiResponse(code=500, message = "Server Error")})	@PutMapping("/{id}")
	public User updateUser(@RequestBody User user, @PathVariable ("id") long userId) {
		 User addUsers = this.userRepository.findById(userId)
			.orElseThrow(() -> new ResourceNotFoundException("Error id not Found" + userId));
		 addUsers.setFirstName(user.getFirstName());
		 addUsers.setLastName(user.getLastName());
		 addUsers.setEmail(user.getEmail());
		 return this.userRepository.save(addUsers);
	}

	@ApiOperation(value = "Delete User", notes = "Delete User with matching Id")
	@ApiResponses(value ={@ApiResponse( code = 200, message = "Deleted"), @ApiResponse(code = 400, message = "Invalid id"), @ApiResponse(code=500, message = "Server Error")})
	@DeleteMapping("/{id}")
	public ResponseEntity<User> deleteUser(@PathVariable ("id") long userId){
		 User existingUser = this.userRepository.findById(userId)
					.orElseThrow(() -> new ResourceNotFoundException("Error id not Found:" + userId));
		 this.userRepository.delete(existingUser);
		 return ResponseEntity.ok().build();
	}
}
