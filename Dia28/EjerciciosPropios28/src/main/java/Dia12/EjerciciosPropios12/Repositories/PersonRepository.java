package Dia12.EjerciciosPropios12.Repositories;

import Dia12.EjerciciosPropios12.Models.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long>  {
    public abstract ArrayList<Person> findByDni(String dni);
    public abstract ArrayList<Person> findPersonByVoted(boolean voted);

}
