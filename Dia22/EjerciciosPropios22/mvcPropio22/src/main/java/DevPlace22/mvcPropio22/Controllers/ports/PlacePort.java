package DevPlace22.mvcPropio22.Controllers.ports;

import DevPlace22.mvcPropio22.Controllers.adapters.PlaceAdapter;

import DevPlace22.mvcPropio22.models.Person;
import DevPlace22.mvcPropio22.models.Place;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import kong.unirest.HttpResponse;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.ArrayList;

@Service
public class PlacePort {

PlaceAdapter pA = new PlaceAdapter();

    public ArrayList<Place> getPlaces()
    {

        HttpResponse<String> httpResponse = pA.getPlaces();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String data = gson.toJson(JsonParser.parseString(httpResponse.getBody()));
        Type userListType = new TypeToken<ArrayList<Place>>(){}.getType();

        return gson.fromJson(data, userListType);

    }

    public void addPlace(Place place)
    {
        pA.savePlace(place);
    }

}

