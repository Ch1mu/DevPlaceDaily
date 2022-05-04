package DevPlace22.mvcPropio22.Controllers;


import DevPlace22.mvcPropio22.Controllers.ports.PlacePort;
import DevPlace22.mvcPropio22.models.Person;
import DevPlace22.mvcPropio22.models.Place;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/places")
public class PlaceController {
    @Autowired
    private PlacePort pP;


    @GetMapping
    public String getAll(Model model)
    {
        model.addAttribute("places", pP.getPlaces());
        return "PlaceTemplates/index";
    }

    @PostMapping("/save")
    public String saveVehicle(@ModelAttribute("place") Place place) {
        pP.addPlace(place);
        return "redirect:/places";
    }

}
