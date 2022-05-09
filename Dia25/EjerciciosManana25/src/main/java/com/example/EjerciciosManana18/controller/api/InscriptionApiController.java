package com.example.EjerciciosManana18.controller.api;

import com.example.EjerciciosManana18.controller.service.InscriptionService;
import com.example.EjerciciosManana18.controller.service.StudentService;
import com.example.EjerciciosManana18.controller.service.SubjectService;
import com.example.EjerciciosManana18.model.Inscription;
import com.example.EjerciciosManana18.model.Student;
import com.example.EjerciciosManana18.model.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/inscriptions")
public class InscriptionApiController {
	
	@Autowired 
	private InscriptionService is;
	
	@Autowired
	private StudentService stus;
	
	@Autowired
	private SubjectService subs;
	
	@GetMapping(value = "/{dni}/{code}",  produces = { "application/json", "application/xml" })
	public ResponseEntity inscription(@PathVariable("dni") long dni, @PathVariable("code") long code) {
		Inscription i = is.checkins(dni, code);
		if(i == null)
		{
			Student stu = stus.getStudent(dni);
			Subject sub = subs.getSubject(code);
			is.insertInscription(stu, sub);
			return ResponseEntity.ok().body("Success.");

		}

		return ResponseEntity.badRequest().body("Invalid DNI or Code");
	}
	
	
}
