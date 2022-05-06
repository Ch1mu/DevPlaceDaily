package Dia20.EjerciciosPropios20.Controllers.Repositories;

import Dia20.EjerciciosPropios20.Models.Users;
    import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends JpaRepository<Users, Long> {
    public Users findByUsername(String username);
}
