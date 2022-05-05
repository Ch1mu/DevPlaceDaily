package Dia21.EjerciciosPropios21.Controllers.Repositories;

import Dia21.EjerciciosPropios21.Models.Vehicle;


import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;


import java.util.ArrayList;

@Repository
public class VehicleRepository {

    public ArrayList<Vehicle> findAll() {
        String url = "http://localhost:8080/vehicles";
        RestTemplate rt = new RestTemplate();
        ArrayList<Vehicle> Vehicle = new ArrayList<>();
        Vehicle = rt.getForObject(url, ArrayList.class);
        return Vehicle;
    }
    public Vehicle getById(long id) {
        String url = "http://localhost:8080/vehicles/" + id;
        RestTemplate rt = new RestTemplate();
        Vehicle Vehicle = new Vehicle();
        Vehicle = rt.getForObject(url, Vehicle.class);
        return Vehicle;
    }
    public void save(Vehicle es) {
        String url = "http://localhost:8080/vehicles/save";
        RestTemplate rt = new RestTemplate();
        rt.postForObject(url, es, Vehicle.class);
    }

    public void delete(long id) {
        String url = "http://localhost:8080/vehicles/delete/" + id;
        RestTemplate rt = new RestTemplate();
        rt.delete(url);
    }

    public void update(Vehicle es) {
        String url = "http://localhost:8080/vehicles/update" + es.getId();
        RestTemplate rt = new RestTemplate();
        rt.put(url, es, Vehicle.class);
    }

    public ArrayList<Vehicle> getByType(String type){
        String url = "http://localhost:8080/vehicles/type/"+type;
        RestTemplate rt = new RestTemplate();
        ArrayList<Vehicle> vehicle;
        vehicle = rt.getForObject(url, ArrayList.class);
        return vehicle;
    }





}
