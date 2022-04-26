package app.ports;

import app.adapters.PlaceAdapter;

import app.models.Place;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParser;
import kong.unirest.HttpResponse;

public class PlacePort {

PlaceAdapter pA = new PlaceAdapter();

    public void getPlaces()
    {
        HttpResponse<String> httpResponse = pA.getPlaces();

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        System.out.println(gson.toJson(JsonParser.parseString(httpResponse.getBody())));
    }
    public void getPlaceById(Long id)
    {
        HttpResponse<String> httpResponse = pA.getPlaceById(id);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        System.out.println(gson.toJson(JsonParser.parseString(httpResponse.getBody())));
    }


    public void addPlace(Place place)
    {
        pA.savePlace(place);
    }
    public void editPlace(Place place, Long id)
    {
        pA.editPlace(place, id);
    }
    public void deletePlace(Long id)
    {
        pA.deletePlace(id);
    }
}

