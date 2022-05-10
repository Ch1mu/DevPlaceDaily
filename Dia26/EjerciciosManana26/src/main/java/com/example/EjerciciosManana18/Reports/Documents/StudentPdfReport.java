package com.example.EjerciciosManana18.Reports.Documents;

import com.example.EjerciciosManana18.model.Student;
import com.lowagie.text.*;
import com.lowagie.text.pdf.*;
import org.springframework.data.domain.Page;

import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;
import java.util.List;

public class StudentPdfReport {

    private List<Student> studentList;
    public StudentPdfReport(List<Student> studentList)
    {
        this.studentList = studentList;
    }

    public void HeaderTable(PdfPTable table)
    {
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(Color.cyan);
        cell.setPadding(5);
        cell.setPhrase(new Phrase("DNI"));
        table.addCell(cell);
        cell.setPhrase(new Phrase("First Name"));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Last Name"));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Phone"));
        table.addCell(cell);

    }
    public void BodyTable(PdfPTable table)
    {
        for(Student student: studentList)
        {
            table.addCell(String.valueOf(student.getDni()));
            table.addCell(student.getName());
            table.addCell(student.getLastname());
            table.addCell(student.getNumberPhone());
        }
    }
    public void export(HttpServletResponse hsr) throws DocumentException, IOException
    {
        Document doc = new Document(PageSize.A4);
        PdfWriter.getInstance(doc, hsr.getOutputStream());
        doc.open();
        Paragraph paragraph = new Paragraph("Student List");
        paragraph.setSpacingAfter(5);
        paragraph.setAlignment(paragraph.ALIGN_CENTER);
        doc.add(paragraph);
        PdfPTable pdf = new PdfPTable(4);
        HeaderTable(pdf);
        BodyTable(pdf);
        doc.add(pdf);
        doc.close();

    }


}
