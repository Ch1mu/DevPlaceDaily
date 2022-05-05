package com.bragadini.matias.repository;

import com.bragadini.matias.model.User;
import com.bragadini.matias.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
   public User getByEmail(String email);

}
