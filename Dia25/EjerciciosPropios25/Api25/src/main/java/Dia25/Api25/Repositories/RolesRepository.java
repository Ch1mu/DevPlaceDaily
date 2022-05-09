package Dia25.Api25.Repositories;

import Dia25.Api25.Models.Roles;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolesRepository extends JpaRepository<Roles, Long> {

    public Roles getById(long id);

}
