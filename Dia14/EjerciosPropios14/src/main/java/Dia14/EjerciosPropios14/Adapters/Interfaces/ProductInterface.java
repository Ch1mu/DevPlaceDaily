package Dia14.EjerciosPropios14.Adapters.Interfaces;

import kong.unirest.HttpResponse;

public interface ProductInterface {
    public HttpResponse<String> getProducts();
    public  HttpResponse<String> getProductById(int i);
}
