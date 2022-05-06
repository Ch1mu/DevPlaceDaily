package Dia20.EjerciciosPropios20.Controllers;

import Dia20.EjerciciosPropios20.Controllers.Services.GameService;
import Dia20.EjerciciosPropios20.Models.Game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(auth.getAuthorities());

        model.addAttribute("games", gS.getAll());
        return "GameTemplates/GameIndex";
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
