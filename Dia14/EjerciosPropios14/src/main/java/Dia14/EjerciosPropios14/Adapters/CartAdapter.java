package Dia14.EjerciosPropios14.Adapters;

import Dia14.EjerciosPropios14.Adapters.Interfaces.CartsInterface;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;

public class CartAdapter implements CartsInterface {
    private final static String url = "http://localhost:8080/Carts/";

    public HttpResponse<String> getCarts()
    {
        return (HttpResponse<String>) Unirest.get(url).asString();
    }

}
