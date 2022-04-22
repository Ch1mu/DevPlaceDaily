package Dia14.EjerciosPropios14.Ports;

import Dia14.EjerciosPropios14.Adapters.ProductAdapter;
import Dia14.EjerciosPropios14.Models.Product;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParser;

import kong.unirest.HttpResponse;


public class ProductPort
{
        ProductAdapter pa;

        public void showProducts()
        {
            HttpResponse<String> products= pa.getProducts();
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            System.out.println(gson.toJson(JsonParser.parseString(products.getBody())));
        }

        public Product getProductById(int id)
        {
            Product p;
            HttpResponse<String> products= pa.getProductById(id);
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            p = gson.fromJson(products.getBody(), Product.class);

            return p;
        }

}
