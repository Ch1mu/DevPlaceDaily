package Dia15.EjerciciosManana15.controllers;


import Dia15.EjerciciosManana15.services.ProductService;
import Dia15.EjerciciosManana15.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@CrossOrigin
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService pS;

    @GetMapping()
    public ArrayList<Product> getClients(){
        return pS.getProducts();
    }

    @PostMapping()
    public Product saveClient(@RequestBody Product prod)
    {
        return pS.saveProduct(prod);
    }

    @GetMapping("/getByCode")
    public ArrayList<Product> getProductByCode(@RequestParam("code") long code){
        return pS.getProductByCode(code);
    }
}
