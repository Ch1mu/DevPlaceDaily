package Dia15.EjerciciosManana15.services;

import Dia15.EjerciciosManana15.repositories.ProductRepository;
import Dia15.EjerciciosManana15.models.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ProductService {
    @Autowired
    ProductRepository pR;

    public ArrayList<Product> getProducts()
    {
        return (ArrayList<Product>) pR.findAll();
    }
    public Product saveProduct(Product product){
        return pR.save(product);
    }
    public ArrayList<Product> getProductByCode(long code)
    {
        return pR.filterByCode(code);
    }
    public boolean deleteByCode(long code)
    {
        try {
            pR.deleteByCode(code);
            return  true;
        }catch (Exception e){
            return  false;
        }

    }
}
