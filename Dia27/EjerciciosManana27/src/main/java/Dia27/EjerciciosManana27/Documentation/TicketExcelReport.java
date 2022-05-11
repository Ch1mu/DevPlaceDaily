package Dia27.EjerciciosManana27.Documentation;


import Dia27.EjerciciosManana27.models.Ticket;
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

public class TicketExcelReport {
    private XSSFSheet sheet;
    private XSSFWorkbook wb;
    private List<Ticket> tickets;

    public TicketExcelReport(List<Ticket> tickets)
    {
        this.tickets = tickets;
        wb =  new XSSFWorkbook();
    }
    public void readHeader()
    {
        sheet = wb.createSheet("Tickets-List");
        Row row = sheet.createRow(0);
        CellStyle cS = wb.createCellStyle();
        XSSFFont font = wb.createFont();
        font.setFontHeight(16);
        font.setBold(true);
        cS.setFont(font);
        createCell(row, 0,"TICKET ID", cS);
        createCell(row, 1,"CLIENT DNI", cS);
        createCell(row, 2,"PRODUCT CODE", cS);
        createCell(row, 2,"PRODUCT AMMOUNT", cS);

    }
    private void createCell(Row row, int pos, Object name, CellStyle cS){


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
        for(Ticket s: tickets)
        {
            Row row = sheet.createRow(rC);
            int cC = 0;
            rC++;
            createCell(row, cC++,s.getNTicket(), cS);
            createCell(row, cC++,s.getClient().getDni(), cS);
            createCell(row, cC++,s.getProd().getName(), cS);
            createCell(row, cC++,s.getAmmountProducts(), cS);

        }

    }
    public void export(HttpServletResponse res) throws IOException
    {
        readHeader();
        readBody();

        for(int i = 0; i<4; i++)
        {
            sheet.autoSizeColumn(i);
        }

        ServletOutputStream stream = res.getOutputStream();
        wb.write(stream);


    }
}
