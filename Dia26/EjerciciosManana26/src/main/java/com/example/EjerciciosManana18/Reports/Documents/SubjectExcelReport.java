package com.example.EjerciciosManana18.Reports.Documents;

import com.example.EjerciciosManana18.model.Student;
import com.example.EjerciciosManana18.model.Subject;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class SubjectExcelReport {
    private XSSFSheet sheet;
    private XSSFWorkbook wb;
    private List<Subject> subjects;

    public SubjectExcelReport(List<Subject> subjects)
    {
        this.subjects = subjects;
        wb =  new XSSFWorkbook();
    }
    public void readHeader()
    {
        sheet = wb.createSheet("Subject-List");
        Row row = sheet.createRow(0);
        CellStyle cS = wb.createCellStyle();
        XSSFFont font = wb.createFont();
        font.setFontHeight(16);
        font.setBold(true);
        cS.setFont(font);
        createCell(row, 0,"Code", cS);
        createCell(row, 1,"Name", cS);

    }
    private void createCell(Row row, int pos, Object name, CellStyle cS){

        sheet.autoSizeColumn(pos);
        Cell cell = (Cell)row.createCell(pos);

        if(name instanceof Integer)
        {
            cell.setCellValue((Integer)name);
        }
        else if(name instanceof Boolean)
        {
            cell.setCellValue((Boolean)name);
        }
        else if(name instanceof Long)
        {
            cell.setCellValue((Long)name);
        }
        else
        {
            cell.setCellValue((String)name);
        }

        cell.setCellStyle(cS);


    }
    private void readBody()
    {
        int rC = 1;
        CellStyle cS = wb.createCellStyle();
        XSSFFont font = wb.createFont();
        font.setFontHeight(12);
        font.setBold(false);
        cS.setFont(font);
        for(Subject s: subjects)
        {
            Row row = sheet.createRow(rC);
            int cC = 0;
            rC++;
            createCell(row, cC++,s.getCode(), cS);
            createCell(row, cC++,s.getName(), cS);

        }

    }
    public void export(HttpServletResponse res) throws IOException
    {
        readHeader();
        readBody();
        ServletOutputStream stream = res.getOutputStream();
        wb.write(stream);


    }
}
