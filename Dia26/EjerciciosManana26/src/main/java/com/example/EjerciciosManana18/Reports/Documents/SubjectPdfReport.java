package com.example.EjerciciosManana18.Reports.Documents;

import com.example.EjerciciosManana18.model.Inscription;
import com.example.EjerciciosManana18.model.Subject;
import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;
import java.util.List;

public class SubjectPdfReport {

    private List<Subject> subjects;
    public SubjectPdfReport(List<Subject> subjects)
    {
        this.subjects = subjects;
    }

    public void HeaderTable(PdfPTable table)
    {
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(Color.cyan);
        cell.setPadding(5);
        cell.setPhrase(new Phrase("Code"));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Name"));
        table.addCell(cell);



    }
    public void BodyTable(PdfPTable table)
    {
        for(Subject subject: subjects)
        {
            table.addCell(String.valueOf(subject.getCode()));
            table.addCell(String.valueOf(subject.getName()));


        }
    }
    public void export(HttpServletResponse hsr) throws DocumentException, IOException
    {
        Document doc = new Document(PageSize.A4);
        PdfWriter.getInstance(doc, hsr.getOutputStream());
        doc.open();
        Paragraph paragraph = new Paragraph("Inscription List");
        paragraph.setSpacingAfter(5);
        paragraph.setAlignment(paragraph.ALIGN_CENTER);
        doc.add(paragraph);
        PdfPTable pdf = new PdfPTable(2);
        HeaderTable(pdf);
        BodyTable(pdf);
        doc.add(pdf);
        doc.close();

    }
}
