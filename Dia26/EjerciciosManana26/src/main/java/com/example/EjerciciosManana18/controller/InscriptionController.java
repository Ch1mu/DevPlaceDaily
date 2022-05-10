package com.example.EjerciciosManana18.controller;
import com.example.EjerciciosManana18.Reports.Documents.InscriptionExcelReport;
import com.example.EjerciciosManana18.Reports.Documents.InscriptionPdfReport;
import com.example.EjerciciosManana18.Reports.Email.Email;
import com.example.EjerciciosManana18.Reports.Email.EmailService;
import com.example.EjerciciosManana18.model.Inscription;
import com.lowagie.text.DocumentException;
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

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/inscriptions")
public class InscriptionController {
	
	@Autowired 
	private InscriptionService is;
	
	@Autowired
	private StudentService stus;
	
	@Autowired
	private SubjectService subs;

	@Autowired
	EmailService eS;

	@GetMapping("/{dni}/{code}")
	public String inscription(@PathVariable("dni") long dni, @PathVariable("code") long code) {
		Inscription i = is.checkins(dni, code);
		if(i == null)
		{
			Student stu = stus.getStudent(dni);
			Subject sub = subs.getSubject(code);
			is.insertInscription(stu, sub);

			Email email = new Email("email@email.com", stu.getName() +" "+ stu.getLastname() +" You are now inscripted into: " + sub.getName(), "Inscription");
			boolean send = eS.sendEmail(email);
		}

		return "redirect:/students/1/10";
	}

	@GetMapping("/pdf/{dni}")
	public void getPdf(@PathVariable("dni") long dni, HttpServletResponse response) throws DocumentException, IOException
	{
		response.setContentType("application/pdf");
		response.setHeader("Content-Disposition", "attachment;filename=Inscription-ListPDF.pdf");

		List<Inscription> inscriptionList = is.getByDni(dni);
		InscriptionPdfReport pdfclass = new InscriptionPdfReport(inscriptionList);
		pdfclass.export(response);

	}
	@GetMapping("/excel/{dni}")
	public void getExcel(@PathVariable("dni") long dni, HttpServletResponse response) throws DocumentException, IOException
	{
		response.setContentType("application/octet-stream");
		response.setHeader("Content-Disposition", "attachment;filename=Inscription-ListExcel.xlsx");
		List<Inscription> inscriptionList = is.getByDni(dni);
		InscriptionExcelReport sER = new InscriptionExcelReport(inscriptionList);
		sER.export(response);


	}
	
	
}
