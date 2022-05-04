package DevPlace22.mvcPropio22.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;




@Getter
@Setter
@NoArgsConstructor

 public class Person {


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
    public Person(Long id, String dni, String address, String firstName, String lastName, int place ,boolean voted) {
        this.firstName = firstName;
        this.id = id;
        this.lastName = lastName;
        this.dni = dni;
        this.address = address;
        this.place = place;
        this.voted = voted;
    }
}
