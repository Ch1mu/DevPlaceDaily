package Dia21.EjerciciosPropios21.Controllers;

import Dia21.EjerciciosPropios21.Controllers.Services.VehicleService;
import Dia21.EjerciciosPropios21.Models.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.Optional;

@Controller
@RequestMapping("vehicles")
public class VehicleController {
    @Autowired
    VehicleService vS;

    //GET ALL
    @GetMapping()
    public String getAll(Model model)
    {
        model.addAttribute("vehicles", vS.getAll());
        return "VehicleTemplates/VehicleIndex";
    }
    @GetMapping("type/{type}")
    public String getAll(Model model, @PathVariable("type") String type)  {


            model.addAttribute("vehicles", vS.getByType(type));
            model.addAttribute("avg", vS.getAvg(type));

        return "VehicleTemplates/VehicleIndex";
    }

    @GetMapping("/save")
    public String vehicleForm(Model model) {
        Vehicle vehicle = new Vehicle();
        model.addAttribute("vehicle", vehicle);
        return "VehicleTemplates/AddForm";
    }

    @PostMapping("/save")
    public String saveVehicle(@ModelAttribute("vehicle") Vehicle vehicle) {
        vS.save(vehicle);
        return "redirect:/vehicles";
    }

    //UPDATE

    @GetMapping("/update/{id}")
    public String updateVehicle(@PathVariable("id") long id, Model model) {
        Optional<Vehicle> game = vS.getById(id);
        model.addAttribute("game", game);
        return "GameTemplates/GameAddForm";
    }

    @PostMapping("/update/{id}")
    public String updateVehicle2(@ModelAttribute("vehicle") Vehicle vehicle, @PathVariable("id") long id) {
        vS.update(vehicle, id);
        return "redirect:/vehicles";
    }

    //DELETE
    @DeleteMapping("{id}")
    public String  delete(@PathVariable("id") long id)
    {
        vS.delete(id);
        return "redirecte:/vehicles";
    }
}
