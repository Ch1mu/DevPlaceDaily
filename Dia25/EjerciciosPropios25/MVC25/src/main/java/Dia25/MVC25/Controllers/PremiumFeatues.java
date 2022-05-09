package Dia25.MVC25.Controllers;

import Dia25.MVC25.Controllers.Services.SongService;
import Dia25.MVC25.Models.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/premium")
public class PremiumFeatues {

    @Autowired
    SongService sS;

@GetMapping("/play/{id}")
    public String playSong(@PathVariable("id") long id, Model model)
    {
        Song song = sS.getById(id);
        model.addAttribute("text", song.playSong());
        return "SongTemplates/play";
    }
}
