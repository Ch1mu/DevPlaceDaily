package Dia25.MVC25.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "songs")
@NoArgsConstructor
@AllArgsConstructor
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotEmpty
    private String title;
    @NotNull
    private double duration;
    private long albumId;


    public String  playSong()
    {
        String string = "";
        string += "Playing " + this.getTitle();
        return string;
    }
}
