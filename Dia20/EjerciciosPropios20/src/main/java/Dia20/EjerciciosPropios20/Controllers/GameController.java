package Dia20.EjerciciosPropios20.Controllers;

import Dia20.EjerciciosPropios20.Controllers.Services.GameService;
import Dia20.EjerciciosPropios20.Models.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("games")
public class GameController {
    @Autowired
    GameService gS;

    //GET ALL
    @GetMapping()
    public String getAll(Model model)
    {
        model.addAttribute("games", gS.getAll());
        return "GameTemplates/GameIndex";
    }

    @GetMapping("/save")
    public String gameForm(Model model) {
        Game game = new Game();
        model.addAttribute("game", game);
        return "GameTemplates/GameAddForm";
    }

    @PostMapping("/save")
    public String saveGame(@ModelAttribute("game") Game game) {
        gS.save(game);
        return "redirect:/games";
    }

    //UPDATE

    @GetMapping("/update/{id}")
    public String updateGame(@PathVariable("id") long id, Model model) {
        Optional<Game> game = gS.getById(id);
        model.addAttribute("game", game);
        return "GameTemplates/GameAddForm";
    }

    @PostMapping("/update/{id}")
    public String updateGame(@ModelAttribute("game") Game game, @PathVariable("id") long id) {
        gS.update(game, id);
        return "redirect:/games";
    }

    //DELETE
    @DeleteMapping("{id}")
    public String  delete(@PathVariable("id") long id)
    {
        gS.delete(id);
        return "redirecte:/games";
    }
}
