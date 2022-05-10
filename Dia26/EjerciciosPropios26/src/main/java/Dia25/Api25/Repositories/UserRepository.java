package Dia25.Api25.Repositories;

import Dia25.Api25.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    public User getByEmail(String email);
    public User getById(long id);
}
