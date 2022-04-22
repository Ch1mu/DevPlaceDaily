package Dia14.EjerciosPropios14.Ports;

import Dia14.EjerciosPropios14.Adapters.CartAdapter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParser;
import kong.unirest.HttpResponse;

public class CartPort {
    CartAdapter ca;

    public void showProducts()
    {
        HttpResponse<String> products= ca.getCarts();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        System.out.println(gson.toJson(JsonParser.parseString(products.getBody())));
    }
}
