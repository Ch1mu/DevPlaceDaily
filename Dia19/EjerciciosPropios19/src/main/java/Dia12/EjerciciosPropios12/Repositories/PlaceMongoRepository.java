package Dia12.EjerciciosPropios12.Repositories;

import Dia12.EjerciciosPropios12.Models.Place;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PlaceMongoRepository extends MongoRepository<Place, Long> {
}
