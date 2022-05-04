package DevPlace22.mvcPropio22.Controllers.adapters.Interfaces;


import DevPlace22.mvcPropio22.models.Place;
import kong.unirest.HttpResponse;

public interface PlaceInterface {
    public HttpResponse getPlaces();
    public HttpResponse getPlaceById(Long id);
    public void savePlace(Place place);
    public void editPlace(Place place, Long id);
    public void deletePlace(Long id);

}
