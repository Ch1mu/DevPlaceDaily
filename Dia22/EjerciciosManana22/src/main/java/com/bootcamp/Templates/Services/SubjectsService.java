package com.bootcamp.Templates.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.bootcamp.Templates.Repository.SubjectsRepository;
import com.bootcamp.Templates.Model.Subjects;

@Service
public class SubjectsService {
	
	@Autowired
	private SubjectsRepository subjectsRepository;
	
	public List<Subjects> getAllSubjects(){
		return subjectsRepository.findAll();
	}
	
	public ResponseEntity getOne(int id) {
		if(!subjectsRepository.findById(id).isEmpty())
			return ResponseEntity.ok(subjectsRepository.findById(id).get());
		else
			return ResponseEntity.badRequest().body("Invalid ID");
	}
	
	public boolean saveSubject(Subjects subject) {
		if(subjectsRepository.existsByCode(subject.getCode()))
			return false;
		subjectsRepository.save(subject);
		return true;
	}
	
	public boolean editSubject(Subjects subject) {
		if(!subjectsRepository.existsById(subject.getId())) return false;
		subjectsRepository.save(subject);
		return true;
	}
	
	public boolean deleteSubject(int id) {
		if(!subjectsRepository.existsById(id))
			return false;
		subjectsRepository.deleteById(id);
		return true;
	}
}
