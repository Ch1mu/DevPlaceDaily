package Dia20.EjerciciosPropios20.Controllers;

import Dia20.EjerciciosPropios20.Controllers.Services.GameService;
import Dia20.EjerciciosPropios20.Models.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {


    @Autowired
    GameService gS;

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
}
