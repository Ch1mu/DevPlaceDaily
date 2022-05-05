package Dia21.EjerciciosPropios21.Controllers;

import Dia21.EjerciciosPropios21.Controllers.Services.VehicleService;
import Dia21.EjerciciosPropios21.Models.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;


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

    @GetMapping("/userIndex")
    public String getAllUsers(Model model)
    {
        model.addAttribute("vehicles", vS.getAll());
        return "VehicleTemplates/VehicleUserIndex";
    }

    @GetMapping("type/{type}")
    public String findByType(Model model, @PathVariable("type") String type)  {

            model.addAttribute("vehicles", vS.getByType(type));

        return "VehicleTemplates/VehicleUserIndex";
    }

    @GetMapping("/save")
    public String vehicleForm(Model model) {
        Vehicle vehicle = new Vehicle();
        model.addAttribute("vehicle", vehicle);
        return "VehicleTemplates/AddForm";
    }

    @PostMapping("/save")
    public String saveVehicle(@ModelAttribute("vehicle") @Valid Vehicle vehicle) {
        vS.save(vehicle);
        return "redirect:/vehicles";
    }

    //UPDATE

    @GetMapping("/update/{id}")
    public String updateVehicle(@PathVariable("id") long id, Model model) {
        Vehicle vehicle = vS.getById(id);
        ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
        vehicles.add(vehicle);
        model.addAttribute("vehicles", vehicles);
        return "VehicleTemplates/VehicleIndex";
    }

    @PostMapping("/update/{id}")
    public String updateVehicle2(@ModelAttribute("vehicle") @Valid Vehicle vehicle, @PathVariable("id") long id) {
        vS.update(vehicle, id);
        return "redirect:/vehicles";
    }

    //DELETE
    @GetMapping("delete/{id}")
    public String  delete(@PathVariable("id") long id)
    {
        vS.delete(id);
        return "redirect:/vehicles";
    }
}
