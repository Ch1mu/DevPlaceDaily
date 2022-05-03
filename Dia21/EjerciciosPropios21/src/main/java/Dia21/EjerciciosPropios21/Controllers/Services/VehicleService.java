package Dia21.EjerciciosPropios21.Controllers.Services;

import Dia21.EjerciciosPropios21.Controllers.Repositories.VehicleRepository;
import Dia21.EjerciciosPropios21.Models.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class VehicleService {
    @Autowired
    VehicleRepository vR;

    //SAVE
    public Vehicle save(Vehicle vehicle)
    {
        return vR.save(vehicle);
    }

    //GET ALL
    public ArrayList<Vehicle> getAll()
    {
        return (ArrayList<Vehicle>) vR.findAll();
    }

    //GET BY ID
    public Optional<Vehicle> getById(long id)
    {
        return vR.findById(id);
    }

    //DELETE
    public void delete(long id)
    {
        vR.deleteById(id);
    }

    //UPDATE
    public Vehicle update(Vehicle vehicle, long id)
    {
        vehicle.setId(id);
        return vR.save(vehicle);
    }

    //GET BY TYPE
    public ArrayList<Vehicle> getByType(String type) {

    return vR.getByType(type);
    }
    public double getAvg(String type)
    {
        return vR.getAvg(type);
    }
}
