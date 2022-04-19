package dia11.ejerciciosPropios11.controllers;

import dia11.ejerciciosPropios11.models.Alfajor;
import org.springframework.web.bind.annotation.*;
import dia11.ejerciciosPropios11.services.AlfajorService;

import java.util.ArrayList;

    @RestController
    @RequestMapping("/alfajor")
    public class AlfajorController {

    AlfajorService aService = new AlfajorService();

    @GetMapping()
    public ArrayList<Alfajor> getAlfajores()
    {
        return aService.getAlfajores();
    }



    @GetMapping("/types")
    public ArrayList<Alfajor> getAlfajoresByType(@RequestParam("type") String type)
    {
        return aService.getAlfajoresByType(type);
    }

    @DeleteMapping("/delete/{id}")
        public void delete(@PathVariable("id") int id)
    {
        aService.deleteById(id);
    }
    @PostMapping
        public void putAlfajor(@RequestBody Alfajor alfajor)
    {
        aService.putAlfajor(alfajor);
    }

    }
