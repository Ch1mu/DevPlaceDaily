package com.example.EjerciciosManana18.controller;

import com.example.EjerciciosManana18.Reports.Documents.SubjectExcelReport;
import com.example.EjerciciosManana18.Reports.Documents.SubjectPdfReport;
import com.example.EjerciciosManana18.controller.service.SubjectService;
import com.example.EjerciciosManana18.model.Subject;
import com.lowagie.text.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/subjects")
public class SubjectController {
    @Autowired
    private SubjectService ss;

    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("subjects", ss.getAll());
        return "Subjects/subjectIndex";
    }

    @GetMapping("/createSubject")
    public String showSubjectForm(Model model) {
        Subject sub = new Subject();
        model.addAttribute("subject", sub);
        return "Subjects/subjectCreate";
    }

    @PostMapping("/createSubject")
    public String insertSubject(@ModelAttribute("subject") Subject sub) {
        ss.insertSubject(sub);
        return "redirect:/subjects";
    }

    @GetMapping("/update/{code}")
    public String showSubject(Model model, @PathVariable("code") long code ) {
        Subject sub = ss.getSubject(code);
        model.addAttribute("subject", sub);
        return "Subjects/subjectUpdate";
    }

    @PostMapping("/update/{code}")
    public String updateSubject(@ModelAttribute("subject") Subject sub, @PathVariable("code") long code) {
        ss.updateSubject(sub);
        return "redirect:/subjects";
    }

    @GetMapping("/delete/{code}")
    public String deleteUser(@PathVariable("code") long code ){
        ss.deleteSubject(code);
        return "redirect:/subjects";
    }

    @GetMapping("/pdf")
    public void getPdf(HttpServletResponse response) throws DocumentException, IOException
    {
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment;filename=Subjects-ListPDF.pdf");

        List<Subject> inscriptionList = ss.getAll();
        SubjectPdfReport pdfclass = new SubjectPdfReport(inscriptionList);
        pdfclass.export(response);

    }
    @GetMapping("/excel")
    public void getExcel(HttpServletResponse response) throws DocumentException, IOException
    {
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment;filename=Subjects-ListExcel.xlsx");
        List<Subject> inscriptionList = ss.getAll();
        SubjectExcelReport sER = new SubjectExcelReport(inscriptionList);
        sER.export(response);


    }
}



