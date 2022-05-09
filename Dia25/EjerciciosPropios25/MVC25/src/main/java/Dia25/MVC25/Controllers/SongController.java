package Dia25.MVC25.Controllers;

import Dia25.MVC25.Controllers.Services.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/songs")
public class SongController {

    @Autowired
    SongService sS;
    @GetMapping("/{id}")
    public String enterAlbum(@PathVariable("id") long id, Model model)
    {
        model.addAttribute("songs", sS.songsPerAlbum(id));
        return "SongTemplates/songsPerAlbum";
    }
}
