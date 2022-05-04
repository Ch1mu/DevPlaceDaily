package com.bootcamp.Templates.Services;

import java.util.List;

import org.hibernate.annotations.Cascade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.bootcamp.Templates.Model.Users;
import com.bootcamp.Templates.Repository.UsersRepository;

import javax.persistence.CascadeType;

@Service
public class UsersService {
	
	@Autowired
	private UsersRepository usersRepository;
	
	public List<Users> getAllUsers(){
		return usersRepository.findAll();
	}
	
	public ResponseEntity getOneUser(int id) {
		if(!usersRepository.findById(id).isEmpty())
			return ResponseEntity.ok(usersRepository.findById(id).get());
		else
			return ResponseEntity.badRequest().body("Invalid ID");
	}
	
	public boolean saveUser(Users user) {
		if(usersRepository.existsByUsername(user.getUsername())) return false;
		usersRepository.save(user);
		return true;
	}
	
	public boolean updateUser(Users user) {
		if(!usersRepository.existsById(user.getId())) return false;
		usersRepository.save(user);
		return true;
	}

	public boolean deleteUser(int id) {
		if(!usersRepository.existsById(id)) return false;
		usersRepository.deleteById(id);
		return true;
	}
}
