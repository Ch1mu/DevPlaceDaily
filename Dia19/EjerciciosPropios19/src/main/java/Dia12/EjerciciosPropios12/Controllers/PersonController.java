package Dia12.EjerciciosPropios12.Controllers;

import Dia12.EjerciciosPropios12.Models.Person;
import Dia12.EjerciciosPropios12.Repositories.PersonRepository;
import Dia12.EjerciciosPropios12.Services.PersonService;

import Dia12.EjerciciosPropios12.Services.ServicesInterfaces.PserviceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@RestController
@CrossOrigin
@RequestMapping("/persons")
public class PersonController {

    @Autowired
    PersonService pService;


    //GET ALL PERSONS
    @GetMapping()
    public ArrayList<Person> getAllPersons()
    {
        return pService.getPersons();
    }

    //SAVE PERSON
    @PostMapping()
    public Person savePerson(@RequestBody Person person)
    {
        return this.pService.savePerson(person);
    }

    //EDIT PERSON
    @PostMapping("/edit/{id}")
    public Person editPerson(@RequestBody Person person, @PathVariable("id") Long id)
    {
        return this.pService.editPerson(person, id);
    }

    //FIND BY DNI
    @GetMapping(path = "/findDni")
    public ArrayList<Person> getPersonByDni(@RequestParam("dni") String dni)
    {
        return pService.byDni(dni);
    }

    // HAS VOTED?
    @GetMapping(path = "/findVoted")
    public ArrayList<Person> getVoted(@RequestParam("voted") boolean voted)
    {
        return pService.findPersonByVoted(voted);
    }

    //DELETE PERSON BY ID
    @DeleteMapping (path = "/{id}")
    public String deletePersonById(@PathVariable("id") Long id)
    {
        boolean ok = this.pService.deleteById(id);

        if(ok)
        {
            return "DELETE: " + id;
        }
        else
        {
            return "COULDN'T DELETE" + id;
        }
    }

}
