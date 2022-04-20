package Dia12.EjerciciosPropios12.Services;

import Dia12.EjerciciosPropios12.Models.Place;
import Dia12.EjerciciosPropios12.Repositories.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class PlaceService {

    @Autowired
   PlaceRepository pRepo;

    //GET ALL PERSONS
    public ArrayList<Place> getPlaces()
    {
        return (ArrayList<Place>) pRepo.findAll();
    }
    //INSERT PERSON INTO API
    public Place savePlace(Place place)
    {
        return pRepo.save(place);

    }
    public Optional<Place> getPlaceById(long id)
    {
        return pRepo.findById(id);
    }
    public boolean deletePlace(Long id)
    {
        try {
            pRepo.deleteById(id);
            return true;
        }catch (Exception e)
        {
            return false;
        }

    }
}
