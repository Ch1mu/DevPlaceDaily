package net.DevPlaceManana.springboot.repository;

import org.springframework.stereotype.Repository;
import net.DevPlaceManana.springboot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
