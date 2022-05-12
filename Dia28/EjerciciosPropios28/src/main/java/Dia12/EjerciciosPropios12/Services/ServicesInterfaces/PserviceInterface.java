package Dia12.EjerciciosPropios12.Services.ServicesInterfaces;

import Dia12.EjerciciosPropios12.Models.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public interface PserviceInterface {
    public ArrayList<Person> getPersons();
    public Person savePerson(Person person);
    public ArrayList<Person> byDni(String dni);
    public ArrayList<Person> findPersonByVoted(boolean voted);
    public Person editPerson(Person person, Long id);
    public boolean deleteById(Long id);

}
