package Dia20.EjerciciosPropios20.Controllers.Repositories;

import Dia20.EjerciciosPropios20.Models.Game;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends CrudRepository<Game, Long> {
}
