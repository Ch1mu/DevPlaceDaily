package com.bragadini.matias.controller;


import com.bragadini.matias.model.Vehicle;
import com.bragadini.matias.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("vehicles")
public class VehicleController {
    @Autowired
    VehicleService vs;

    //GET ALL VEHICLES
    @GetMapping
    public ArrayList<Vehicle> getAllVehicles(){
        return vs.getAll();
    }


    @PostMapping("/save")
    public void saveVehicle(@RequestBody Vehicle v){
        vs.insert(v);
    }

    @PutMapping("/update/{id}")
    public void update(@RequestBody Vehicle v) {
        vs.update(v);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteVehicle(@PathVariable("id") long id){
        vs.deleteById(id);
    }

    @GetMapping("type/{type}")
    public ArrayList<Vehicle> getVehiclesByType(@PathVariable("type") String type){
        return vs.getVehicleByType(type);
    }



}
