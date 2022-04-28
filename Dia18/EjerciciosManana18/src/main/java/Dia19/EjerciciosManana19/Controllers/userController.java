package Dia19.EjerciciosManana19.Controllers;

import Dia19.EjerciciosManana19.models.User;
import Dia19.EjerciciosManana19.services.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;



@Controller
@RequestMapping("/users")
public class userController {

    @Autowired
    userService uS;

    @GetMapping()
    public String getUsers(Model model)
    {
        model.addAttribute("users", uS.getUsers());
        return  "Users/index";
    }
    @GetMapping("/create")
    public String showFormUser(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "Users/createUser";
    }

    @PostMapping("/create")
    public String saveUser(@ModelAttribute("user") User user) {
            uS.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping("/update/{id}")
    public String updateUser(@PathVariable("id") long id, Model model) {
        User user = uS.getUserById(id);
        model.addAttribute("user", user);
        return "Users/editUser";
    }
    @PostMapping("/update/{id}")
    public String updateUser(@ModelAttribute("user") User user, @PathVariable("id") int id) {

        uS.editUser(user, id);
        return "redirect:/users";
    }
    @DeleteMapping("delete/{id}")
    public String deleteUser(@PathVariable("id") int id) {

        uS.deleteUser(id);
        return "redirect:/users";
    }
}
