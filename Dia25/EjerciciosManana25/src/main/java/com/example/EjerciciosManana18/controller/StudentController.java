package com.example.EjerciciosManana18.controller;

import com.example.EjerciciosManana18.Reports.StudentPdfReport;
import com.example.EjerciciosManana18.controller.service.StudentService;
import com.example.EjerciciosManana18.controller.service.SubjectService;
import com.example.EjerciciosManana18.model.Student;
import com.example.EjerciciosManana18.model.Subject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.example.EjerciciosManana18.model.User;
import com.lowagie.text.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService ss;
    
    @Autowired
    private SubjectService subs;
    

    @GetMapping("/{pagNum}/{pagSize}")
    public String getAll(Model model, @PathVariable int pagNum, @PathVariable int pagSize) {

        Page<Student> students= ss.getAll(pagNum, pagSize);
        List<Student> allStudents = students.getContent();
        model.addAttribute("students", students);
        model.addAttribute("allStudents", allStudents);
        model.addAttribute("totalPage", students.getTotalPages());
        model.addAttribute("totalElements", students.getTotalElements());
        model.addAttribute("numPageActual", pagNum);
        model.addAttribute("numSize", pagSize);
        return "Student/studentIndex";
    }
    @GetMapping("/asc/{pagNum}/{pagSize}")
    public String asc(Model model, @PathVariable int pagNum, @PathVariable int pagSize) {
        String name = "";
        String lastname ="";
        Page<Student> students= ss.ascendant(pagNum, pagSize);
        List<Student> allStudents = students.getContent();
        model.addAttribute("students", students);
        model.addAttribute("allStudents", allStudents);
        model.addAttribute("totalPage", students.getTotalPages());
        model.addAttribute("totalElements", students.getTotalElements());
        model.addAttribute("numPageActual", pagNum);
        model.addAttribute("numSize", pagSize);
        model.addAttribute("name",  name);
        model.addAttribute("lastname", lastname);
        return "Student/studentAscendant";
    }
    @GetMapping("/desc/{pagNum}/{pagSize}")
    public String desc(Model model, @PathVariable int pagNum, @PathVariable int pagSize) {

        Page<Student> students= ss.desc(pagNum, pagSize);
        List<Student> allStudents = students.getContent();
        model.addAttribute("students", students);
        model.addAttribute("allStudents", allStudents);
        model.addAttribute("totalPage", students.getTotalPages());
        model.addAttribute("totalElements", students.getTotalElements());
        model.addAttribute("numPageActual", pagNum);
        model.addAttribute("numSize", pagSize);
        return "Student/studentDescendant";
    }

    @GetMapping("/createStudent")
    public String showStudentForm(Model model) {
        Student sub = new Student();
        model.addAttribute("student", sub);
        return "Student/studentCreate";
    }

    @PostMapping("/createStudent")
    public String insertStudent(@ModelAttribute("student") Student sub) {
        ss.insertStudent(sub);
        return "redirect:/students/1/10";
    }

    @GetMapping("/update/{dni}")
    public String showStudent(Model model, @PathVariable("dni") long dni ) {
        Student sub = ss.getStudent(dni);
        model.addAttribute("student", sub);
        return "Student/studentUpdate";
    }

    @PostMapping("/update/{dni}")
    public String updateSubject(@ModelAttribute("student") Student sub, @PathVariable("dni") long dni) {
        ss.updateStudent(sub);
        return "redirect:/students";
    }

    @GetMapping("/delete/{dni}")
    public String deleteUser(@PathVariable("dni") long dni ){
        ss.deleteStudent(dni);
        return "redirect:/students";
    }
    
    @GetMapping("/inscription/{dni}")
    public String showInscription(@PathVariable("dni") long dni, Model model) {
    	Student stu = ss.getStudent(dni);
    	ArrayList<Subject> subjects = (ArrayList<Subject>) subs.getAll();
    	model.addAttribute("student", stu);
    	model.addAttribute("subjects", subjects);
    	return "inscriptionSubject";
    }

    @GetMapping("/byName")
    public String filter(Model model) {
        String name = "";
        model.addAttribute("name", name);
        return "Student/filterByName";
    }

    @PostMapping("/byName")
    public String byName(@RequestParam("name")String name, Model model)
    {
        model.addAttribute("students", ss.byName(name));
        return "Student/studentFilterTable";
    }

    @GetMapping("/byLastName")
    public String byLastName(Model model) {
        String name = "";
        model.addAttribute("lastname", name);
        return "Student/filterbylastName";
    }

    @PostMapping("/byLastname")
    public String byLastName(@RequestParam("lastname")String name, Model model)
    {
        model.addAttribute("students", ss.byLastName(name));
        return "Student/studentFilterTable";
    }

    @GetMapping("/pdf")
    public void getPdf(HttpServletResponse response) throws DocumentException, IOException
    {
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment;filename=Student-List.pdf");

        List<Student> students = ss.findAll();
        StudentPdfReport pdfclass = new StudentPdfReport(students);
        pdfclass.export(response);

    }
}
