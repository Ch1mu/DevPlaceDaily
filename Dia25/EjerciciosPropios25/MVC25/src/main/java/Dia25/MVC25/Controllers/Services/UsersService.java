package Dia25.MVC25.Controllers.Services;


import Dia25.MVC25.Controllers.MicroServices.Adapters.UserAdapter;
import Dia25.MVC25.Models.Users;
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
public class UsersService implements UserDetailsService {

    @Autowired
    private UserAdapter lR;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Users user = lR.getByEmail(email);
        List<GrantedAuthority> roles = new ArrayList<>();

        if(lR.isAdmin(email))
        {

            roles.add(new SimpleGrantedAuthority("ROLE_PREMIUM"));
        }
        else {

            roles.add(new SimpleGrantedAuthority("ROLE_NORMAL"));
            }

        UserDetails uD = new User(user.getEmail(), user.getPassword(), roles);
      return uD;
    }
}
