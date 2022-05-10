package com.example.EjerciciosManana18.Reports.Documents;

import com.example.EjerciciosManana18.model.Inscription;
import com.example.EjerciciosManana18.model.Student;
import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;
import java.util.List;

public class InscriptionPdfReport {

    private List<Inscription> inscriptionList;
    public InscriptionPdfReport(List<Inscription> inscriptionList)
    {
        this.inscriptionList = inscriptionList;
    }

    public void HeaderTable(PdfPTable table)
    {
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(Color.cyan);
        cell.setPadding(5);
        cell.setPhrase(new Phrase("Inscription ID"));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Subject"));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Student"));
        table.addCell(cell);


    }
    public void BodyTable(PdfPTable table)
    {
        for(Inscription inscription: inscriptionList)
        {
            table.addCell(String.valueOf(inscription.getId()));
            table.addCell(String.valueOf(inscription.getCode()));
            table.addCell(String.valueOf(inscription.getDni()));

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
        PdfPTable pdf = new PdfPTable(3);
        HeaderTable(pdf);
        BodyTable(pdf);
        doc.add(pdf);
        doc.close();

    }
}
