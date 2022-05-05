package Dia21.EjerciciosPropios21.Controllers.Services;

import Dia21.EjerciciosPropios21.Controllers.Repositories.VehicleRepository;
import Dia21.EjerciciosPropios21.Models.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.Optional;

@Service
public class VehicleService {
    @Autowired
    VehicleRepository vR;

    //SAVE
    public void save(Vehicle vehicle)
    {
         vR.save(vehicle);
    }

    //GET ALL
    public ArrayList<Vehicle> getAll()
    {
        return (ArrayList<Vehicle>) vR.findAll();
    }

    //GET BY ID
    public Vehicle getById(long id)
    {
        return vR.getById(id);
    }

    //DELETE
    public void delete(long id)
    {
        vR.delete(id);
    }

    //UPDATE
    public void update(Vehicle vehicle, long id)
    {
        vehicle.setId(id);
         vR.save(vehicle);
    }

    //GET BY TYPE
    public ArrayList<Vehicle> getByType(String type) {
    return vR.getByType(type);

    }

}
