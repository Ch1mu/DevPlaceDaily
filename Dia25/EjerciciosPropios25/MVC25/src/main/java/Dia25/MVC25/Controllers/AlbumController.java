package Dia25.MVC25.Controllers;

import Dia25.MVC25.Controllers.Services.AlbumService;
import Dia25.MVC25.Models.Album;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/albums")
public class AlbumController {

    @Autowired
    private AlbumService aS;

    @GetMapping
    public String getAll(Model model)
    {
        model.addAttribute("albums", aS.getAll());
        return "AlbumTemplates/index";
    }


}
