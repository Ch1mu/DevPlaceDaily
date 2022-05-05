package com.bragadini.matias.repository;

import com.bragadini.matias.model.User;
import com.bragadini.matias.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

    @Query(value = "select * from vehicles v where v.vehicle_type = :type", nativeQuery = true)
    public ArrayList<Vehicle> getByType(@Param("type") String type);

}
