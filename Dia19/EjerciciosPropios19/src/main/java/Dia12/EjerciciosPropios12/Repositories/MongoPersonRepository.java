package Dia12.EjerciciosPropios12.Repositories;

import Dia12.EjerciciosPropios12.Models.Person;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface MongoPersonRepository extends MongoRepository<Person, Long> {
    public abstract ArrayList<Person> byDni(String dni);
    public abstract ArrayList<Person> voted(boolean voted);

}
