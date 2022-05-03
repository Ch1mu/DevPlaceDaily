package Dia21.EjerciciosPropios21.Controllers.Repositories;

import Dia21.EjerciciosPropios21.Models.Vehicle;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@Repository
public interface VehicleRepository extends CrudRepository<Vehicle, Long> {



    @Query(value = "select * from vehicles v where v.vehicle_type = :type", nativeQuery = true)
    public ArrayList<Vehicle> getByType(@Param("type") String type);

    @Query(value = "select AVG(price) from vehicles v where v.vehicle_type = :type", nativeQuery = true)
    public double getAvg(@Param("type") String type);
}
