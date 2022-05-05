package Dia21.EjerciciosPropios21.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @NotEmpty
    @Email
    private String email;
    @NotEmpty
    private String password;
    private boolean admin;

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
