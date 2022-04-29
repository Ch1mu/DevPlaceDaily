package Dia12.EjerciciosPropios12.Controllers;


import Dia12.EjerciciosPropios12.Models.Person;
import Dia12.EjerciciosPropios12.Models.Place;
import Dia12.EjerciciosPropios12.Services.PersonService;
import Dia12.EjerciciosPropios12.Services.PlaceService;
import Dia12.EjerciciosPropios12.Services.ServicesInterfaces.PlaceServiceInterface;
import Dia12.EjerciciosPropios12.Services.ServicesInterfaces.PserviceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/places")

public class PlaceController {

    @Autowired
    PlaceServiceInterface pService;



    //GET ALL PLACES
    @GetMapping()
    public ArrayList<Place> getAllPlaces()
    {
        return pService.getPlaces();
    }
    //GET PLACE BY ID
    @GetMapping("/{id}")
    public Optional<Place> getPlaceById(@PathVariable("id") Long id)
    {
        return this.pService.getPlaceById(id);
    }

    //SAVE PLACE
    @PostMapping()
    public Place savePlace(@RequestBody Place place)
    {
        return this.pService.savePlace(place);
    }

    //EDIT PLACE
    @PostMapping("/edit/{id}")
    public Place editPlace(@RequestBody Place place, @PathVariable("id") Long id)
    {
        return pService.editPlace(place, id);
    }

    //DELETE PLACE BY ID
    @DeleteMapping (path = "/{id}")
    public String deletePlaceById(@PathVariable("id") Long id)
    {
        boolean ok = this.pService.deletePlace(id);

        if(ok)
        {
            return "DELETE: " + id;
        }
        else
        {
            return "COULDN'T DELETE" + id;
        }
    }
}
