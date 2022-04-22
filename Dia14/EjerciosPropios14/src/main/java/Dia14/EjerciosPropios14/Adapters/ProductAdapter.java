package Dia14.EjerciosPropios14.Adapters;

import Dia14.EjerciosPropios14.Adapters.Interfaces.ProductInterface;
import kong.unirest.Unirest;

import kong.unirest.HttpResponse;

public class ProductAdapter implements ProductInterface {

    private final static String url = "http://localhost:8080/product/";

    public  HttpResponse<String> getProducts()
    {
        return (HttpResponse<String>) Unirest.get(url).asString();
    }

    public HttpResponse<String> getProductById(int id)
    {
    return(HttpResponse<String>) Unirest.get(url + id).asString();
    }


}
