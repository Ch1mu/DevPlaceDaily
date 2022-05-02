package Dia20.EjerciciosPropios20.Controllers.Services;

import Dia20.EjerciciosPropios20.Controllers.Repositories.GameRepository;
import Dia20.EjerciciosPropios20.Models.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class GameService {

    @Autowired
    GameRepository gR;

    //SAVE
    public Game save(Game game)
    {
        return gR.save(game);
    }

    //GET ALL
    public ArrayList<Game> getAll()
    {
        return (ArrayList<Game>) gR.findAll();
    }

    //GET BY ID
    public Optional<Game> getById(long id)
    {
        return gR.findById(id);
    }

    //DELETE
    public void delete(long id)
    {
        gR.deleteById(id);
    }

    //UPDATE
    public Game update(Game game, long id)
    {
        game.setId(id);
        return gR.save(game);
    }

}
