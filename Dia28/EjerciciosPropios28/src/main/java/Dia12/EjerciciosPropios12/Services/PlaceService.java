package Dia12.EjerciciosPropios12.Services;

import Dia12.EjerciciosPropios12.Models.Person;
import Dia12.EjerciciosPropios12.Models.Place;
import Dia12.EjerciciosPropios12.Repositories.PlaceRepository;
import Dia12.EjerciciosPropios12.Services.ServicesInterfaces.PlaceServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Optional;

@Service
@RequestMapping("/places")
public class PlaceService implements PlaceServiceInterface {

    @Autowired
   PlaceRepository pRepo;
    @Autowired
    UserService uS;
    //GET ALL PERSONS
    public ArrayList<Place> getPlaces()
    {

        ArrayList<Place> places = (ArrayList<Place>) pRepo.findAll();
        ArrayList<Place> userPlaces = new ArrayList<>();
        userPlaces.add(places.get(0));
        SimpleGrantedAuthority s = new SimpleGrantedAuthority("ADMIN");

        if(SecurityContextHolder.getContext().getAuthentication().getAuthorities().contains(s))
        {
            return places;
        }
        else {
            return userPlaces;
        }
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

    //EDIT
    public Place editPlace(Place place, Long id)
    {
        place.setId(id);
        return pRepo.save(place);
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
