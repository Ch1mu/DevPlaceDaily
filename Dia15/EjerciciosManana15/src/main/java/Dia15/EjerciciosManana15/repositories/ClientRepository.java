package Dia15.EjerciciosManana15.repositories;

import Dia15.EjerciciosManana15.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
}
