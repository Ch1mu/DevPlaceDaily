package Dia15.EjerciciosManana15.repositories;


import Dia15.EjerciciosManana15.models.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    public ArrayList<Product> filterByCode(long code);
    public void deleteByCode(long code);
}
