package Dia25.Api25.Controllers;

import Dia25.Api25.Models.Roles;
import Dia25.Api25.Services.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.management.relation.Role;
import java.util.List;

@RestController
@RequestMapping("/roles")
public class RolesController {

    @Autowired
    private RolesService uS;
    @GetMapping
    public List<Roles> getAll()
    {
        return uS.getAll();
    }
    @GetMapping("/isAdmin/{id}")
    public boolean isAdmin(@PathVariable("id") long id)
    {
        return uS.isAdmin(id);
    }

    @GetMapping("/{id}")
    public Roles getById(@PathVariable("id") long id)
    {
        return uS.getById(id);
    }

    @PostMapping("/save")
    public ResponseEntity save(@RequestBody Roles user)
    {
        uS.save(user);
        return ResponseEntity.ok().body("Success.");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable("id") long id)
    {
        uS.delete(id);
        return ResponseEntity.ok().body("Success.");
    }
}
