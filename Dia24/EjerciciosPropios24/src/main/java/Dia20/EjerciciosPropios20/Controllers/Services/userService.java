package Dia20.EjerciciosPropios20.Controllers.Services;

import Dia20.EjerciciosPropios20.Controllers.Repositories.LoginRepository;

import Dia20.EjerciciosPropios20.Models.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class userService implements UserDetailsService {

    @Autowired
    private LoginRepository lR;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Users user = lR.findByUsername(username);
        List<GrantedAuthority> roles = new ArrayList<>();
        roles.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        UserDetails uD = new User(user.getUsername(), user.getPassword(), roles);
      return uD;
    }
}
