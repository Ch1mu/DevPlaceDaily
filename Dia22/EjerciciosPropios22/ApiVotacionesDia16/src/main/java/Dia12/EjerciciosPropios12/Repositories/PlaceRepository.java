package Dia12.EjerciciosPropios12.Repositories;

import Dia12.EjerciciosPropios12.Models.Person;
import Dia12.EjerciciosPropios12.Models.Place;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
    public interface PlaceRepository extends CrudRepository<Place, Long> {

}
