package Dia12.EjerciciosPropios12.Services;

import Dia12.EjerciciosPropios12.Models.Person;
import Dia12.EjerciciosPropios12.Repositories.MongoPersonRepository;
import Dia12.EjerciciosPropios12.Services.ServicesInterfaces.PserviceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PersonMongoService implements PserviceInterface {

    @Autowired
    MongoPersonRepository pRepo;


    //GET ALL PERSONS
    public ArrayList<Person> getPersons()
    {
        return (ArrayList<Person>) pRepo.findAll();
    }

    //INSERT PERSON INTO API
    public Person savePerson(Person person)
    {
        return pRepo.insert(person);

    }

    //FILTER BY DNI
    public ArrayList<Person> findByDni(String dni)
    {
        return pRepo.byDni(dni);
    }
    //FILTER BY "VOTED"
    public ArrayList<Person> findPersonByVoted(boolean voted)
    {
        return pRepo.voted(voted);
    }

    //EDIT
    public Person editPerson(Person person, Long id)
    {
        person.setId(id);
        return pRepo.insert(person);

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
