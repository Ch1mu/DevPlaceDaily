package Dia12.EjerciciosPropios12.Services.ServicesInterfaces;

import Dia12.EjerciciosPropios12.Models.Place;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;
@Service
public interface PlaceServiceInterface {
    //GET ALL PERSONS
    public ArrayList<Place> getPlaces();
    //INSERT PERSON INTO API
    public Place savePlace(Place place);

    public Optional<Place> getPlaceById(long id);

    //EDIT
    public Place editPlace(Place place, Long id);

    public boolean deletePlace(Long id);

}
