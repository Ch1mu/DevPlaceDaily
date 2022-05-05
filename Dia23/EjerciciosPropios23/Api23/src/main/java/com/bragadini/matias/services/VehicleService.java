package com.bragadini.matias.services;

import com.bragadini.matias.model.User;
import com.bragadini.matias.model.Vehicle;
import com.bragadini.matias.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class VehicleService {

    @Autowired
    VehicleRepository vr;

    public ArrayList<Vehicle> getAll(){
            return (ArrayList<Vehicle>) vr.findAll();
    }


    public void insert(Vehicle v){
            vr.save(v);
    }

    public void deleteById(long id){
        vr.deleteById(id);
    }

    public boolean update(Vehicle v){
        if(vr.existsById(v.getId())){
            vr.save(v);
            return true;
        } else return false;
    }

    public ArrayList<Vehicle> getVehicleByType(String type){

        return vr.getByType(type);

    }


}
