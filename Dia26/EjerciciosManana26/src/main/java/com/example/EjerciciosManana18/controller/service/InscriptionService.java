package com.example.EjerciciosManana18.controller.service;


import com.example.EjerciciosManana18.Reports.Email.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.EjerciciosManana18.controller.repositories.InscriptionRepository;
import com.example.EjerciciosManana18.model.Inscription;
import com.example.EjerciciosManana18.model.Student;
import com.example.EjerciciosManana18.model.Subject;

import java.util.List;

@Service
public class InscriptionService {

	@Autowired
	private InscriptionRepository ir;

	public List<Inscription> getAll()
	{
		return ir.findAll();
	}
	public void insertInscription(Student stu, Subject sub) {
		Inscription i = new Inscription();
		i.setDni(stu);
		i.setCode(sub);

	}
	public List<Inscription>getByDni(long dni)
	{
		return ir.getByDni(dni);
	}
	public Inscription checkins(long dni, long code)
	{
		return ir.checkins(dni, code);
	}
}
