package Dia20.EjerciciosPropios20.Models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Date;

@Data
public class Ticket {

    private static long staticId;
    private long id;
    private long gameId;
    private Date date;

    public Ticket()
    {
        staticId++;
        id = staticId;
        date = new Date(System.currentTimeMillis());
    }
}
