package Dia15.EjerciciosManana15.repositories;

import Dia15.EjerciciosManana15.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    public ArrayList<User>filterByEmail(String email);
    public void deleteByEmail(String email);
    public boolean emailExists(String email);
}
