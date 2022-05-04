package Dia12.EjerciciosPropios12.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "Persons")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
 public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
    private String firstName;
    private String lastName;
    private String dni;
    private String address;
    private int place;
    private boolean voted;

    public Person(String firstName, String lastName, String dni, String address, int place, boolean voted) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dni = dni;
        this.address = address;
        this.place = place;
        this.voted = voted;
    }
}
