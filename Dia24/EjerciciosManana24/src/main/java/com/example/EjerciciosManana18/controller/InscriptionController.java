package com.example.EjerciciosManana18.controller;
import com.example.EjerciciosManana18.model.Inscription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.EjerciciosManana18.controller.service.InscriptionService;
import com.example.EjerciciosManana18.controller.service.StudentService;
import com.example.EjerciciosManana18.controller.service.SubjectService;
import com.example.EjerciciosManana18.model.Student;
import com.example.EjerciciosManana18.model.Subject;

@Controller
@RequestMapping("/inscriptions")
public class InscriptionController {
	
	@Autowired 
	private InscriptionService is;
	
	@Autowired
	private StudentService stus;
	
	@Autowired
	private SubjectService subs;
	
	@GetMapping("/{dni}/{code}")
	public String inscription(@PathVariable("dni") long dni, @PathVariable("code") long code) {
		Inscription i = is.checkins(dni, code);
		if(i == null)
		{
			Student stu = stus.getStudent(dni);
			Subject sub = subs.getSubject(code);
			is.insertInscription(stu, sub);

		}

		return "redirect:/students";
	}
	
	
}
