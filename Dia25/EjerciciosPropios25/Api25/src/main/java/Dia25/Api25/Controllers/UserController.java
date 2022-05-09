package Dia25.Api25.Controllers;

import Dia25.Api25.Models.User;
import Dia25.Api25.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService uS;
    @GetMapping
    public List<User> getAll()
    {
        return uS.getAll();
    }

    @PostMapping("/save")
    public ResponseEntity save(@RequestBody User user)
    {
        uS.save(user);
        return ResponseEntity.ok().body("Success.");
    }

    @GetMapping("/{email}")
    public User getByEmail(@PathVariable("email") String email)
    {
        return  uS.getByEmail(email);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable("id") long id)
    {
            uS.delete(id);
        return ResponseEntity.ok().body("Success.");
    }
}
