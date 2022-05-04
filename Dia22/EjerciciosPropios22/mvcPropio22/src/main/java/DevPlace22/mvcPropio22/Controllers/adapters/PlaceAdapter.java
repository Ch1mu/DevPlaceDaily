package DevPlace22.mvcPropio22.Controllers.adapters;

import DevPlace22.mvcPropio22.Controllers.adapters.Interfaces.PlaceInterface;
import DevPlace22.mvcPropio22.models.Place;

import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import org.springframework.stereotype.Repository;

@Repository
public class PlaceAdapter implements PlaceInterface {


    @Override
    public HttpResponse<String> getPlaces() {

        return  Unirest.get("http://localhost:8080/places").asString();
    }

    @Override
    public HttpResponse getPlaceById(Long id) {
        return  Unirest.get("http://localhost:8080/places/" + id).asString();
    }

    @Override
    public void savePlace(Place place) {
        Unirest.post("http://localhost:8080/places").body(place);
    }

    @Override
    public void editPlace(Place place, Long id) {
        Unirest.post("http://localhost:8080/places/edit/" + id).body(place);
    }

    @Override
    public void deletePlace(Long id) {
        Unirest.delete("http://localhost:8080/places/" +id);
    }
}
