package Dia12.EjerciciosPropios12.Services;

import Dia12.EjerciciosPropios12.Models.Person;
import Dia12.EjerciciosPropios12.Repositories.PersonRepository;
import Dia12.EjerciciosPropios12.Services.ServicesInterfaces.PserviceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;

@Service
public class PersonService implements PserviceInterface {


    @Autowired
    PersonRepository pRepo;


    //GET ALL PERSONS
    public ArrayList<Person> getPersons()
    {
        return (ArrayList<Person>) pRepo.findAll();
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
    return pRepo.findPersonByVoted(voted);
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


