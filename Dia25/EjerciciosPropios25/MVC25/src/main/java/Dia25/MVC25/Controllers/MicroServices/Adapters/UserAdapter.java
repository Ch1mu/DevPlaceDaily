package Dia25.MVC25.Controllers.MicroServices.Adapters;

import Dia25.MVC25.Models.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

@Repository
public class UserAdapter {

    @Autowired
    public ArrayList<Users> findAll() {
        String url = "http://localhost:8000/users";
        RestTemplate rt = new RestTemplate();
        ArrayList<Users> User = new ArrayList<>();
        User = rt.getForObject(url, ArrayList.class);
        return User;
    }
    public boolean isAdmin(String email){
        Users user = this.getByEmail(email);

        String url = "http://localhost:8000/roles/isAdmin/"+user.getId();
        RestTemplate rt = new RestTemplate();
        return rt.getForObject(url, Boolean.class);

     }
    public Users getByEmail(String email){
        String url = "http://localhost:8000/users/"+email;
        RestTemplate rt = new RestTemplate();
        Users user;
        user = rt.getForObject(url, Users.class);
        return user;
    }

    public void delete(long id) {
        String url = "http://localhost:8000/users/delete/" + id;
        RestTemplate rt = new RestTemplate();
        rt.delete(url);
    }

    public void save(Users es) {
        String url = "http://localhost:8000/users/save";
        RestTemplate rt = new RestTemplate();
        rt.postForObject(url, es, Users.class);
    }
}
