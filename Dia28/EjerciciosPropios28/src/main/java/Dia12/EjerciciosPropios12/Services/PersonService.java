package Dia12.EjerciciosPropios12.Services;

import Dia12.EjerciciosPropios12.Models.Person;
import Dia12.EjerciciosPropios12.Repositories.PersonRepository;
import Dia12.EjerciciosPropios12.Services.ServicesInterfaces.PserviceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Service
@Component("jpa")
public class PersonService implements PserviceInterface {


    @Autowired
    PersonRepository pRepo;


    //GET ALL PERSONS
    public ArrayList<Person> getPersons()
    {
        ArrayList<Person> persons = (ArrayList<Person>) pRepo.findAll();
        ArrayList<Person> userPerson = new ArrayList<>();
        userPerson.add(persons.get(0));


       SimpleGrantedAuthority s = new SimpleGrantedAuthority("ADMIN");

        if(SecurityContextHolder.getContext().getAuthentication().getAuthorities().contains(s))
        {
            return persons;
        }
        else {
            return userPerson;
        }
    }

    //INSERT PERSON INTO API
    public Person savePerson(Person person)
    {
        return pRepo.save(person);

    }

    //FILTER BY DNI
    public ArrayList<Person> byDni(String dni)
    {
        return pRepo.findByDni(dni);
    }
    //FILTER BY "VOTED"
    public ArrayList<Person> findPersonByVoted(boolean voted)
    {
        ArrayList<Person> persons = (ArrayList<Person>) pRepo.findPersonByVoted(voted);
        ArrayList<Person> userPerson = new ArrayList<>();
        userPerson.add(persons.get(0));
        SimpleGrantedAuthority s = new SimpleGrantedAuthority("ADMIN");

        if(SecurityContextHolder.getContext().getAuthentication().getAuthorities().contains(s))
        {
            return persons;
        }
        else {
            return userPerson;
        }


    }

    //EDIT
    public Person editPerson(Person person, Long id)
    {
        person.setId(id);
        return pRepo.save(person);

    }

    //DELETE
    public boolean deleteById(Long id)
    {
    try {
        pRepo.deleteById(id);
        return true;
    }catch (Exception e)
    {
        return false;
    }
}
}


