package Dia27.EjerciciosManana27.repositories;

import Dia27.EjerciciosManana27.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
