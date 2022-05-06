package com.example.EjerciciosManana18.controller.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.EjerciciosManana18.controller.repositories.StudentRepository;
import com.example.EjerciciosManana18.model.Student;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository sr;
	
	public void insertStudent(Student s) {
		if(!sr.existsById(s.getDni())) {
			sr.save(s);
		}
	}
	
	public void deleteStudent(long dni) {
		if(sr.existsById(dni)) {
			sr.deleteById(dni);
		}
	}

	public Page<Student> getAll(int pagNum, int pagSize){
		Pageable ammount= PageRequest.of(pagNum-1, pagSize);

		return sr.findAll(ammount);
	}
	public ArrayList<Student> findAll(){


		return (ArrayList<Student>) sr.findAll();
	}

	public Page<Student> ascendant(int pagNum, int pagSize)
	{
		Pageable ammount= PageRequest.of(pagNum-1, pagSize);
		return sr.ascendant(ammount);
	}
	public Page<Student> desc(int pagNum, int pagSize)
	{
		Pageable ammount= PageRequest.of(pagNum-1, pagSize);
		return (Page<Student>) sr.descendant(ammount);
	}

	public Student getStudent(long dni) {
		return sr.getById(dni);
	}
	public List<Student> byName(String name)
	{
		return sr.byName(name);
	}
	public ArrayList<Student> byLastName(String name)
	{
		return (ArrayList<Student>) sr.byLastname(name);
	}
	public boolean updateStudent(Student s) {
		if(!sr.existsById(s.getDni())) {
			return false;
		} else {
			sr.save(s);
			return true;			
		}	
	}
}
