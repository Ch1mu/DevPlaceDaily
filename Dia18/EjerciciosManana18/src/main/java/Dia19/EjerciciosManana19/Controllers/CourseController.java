package Dia19.EjerciciosManana19.Controllers;

import Dia19.EjerciciosManana19.models.Course;
import Dia19.EjerciciosManana19.models.User;
import Dia19.EjerciciosManana19.services.CourseService;
import Dia19.EjerciciosManana19.services.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    CourseService cS;

    @GetMapping()
    public String getUsers(Model model) {
        model.addAttribute("courses", cS.getCourses());
        return "Courses/indexCourses";
    }

    @GetMapping("/create")
    public String showCourseUser(Model model) {
        Course course = new Course();
        model.addAttribute("course", course);
        return "Courses/createCourse";
    }

    @PostMapping("/create")
    public String saveUser(@ModelAttribute("course") Course course) {
        cS.saveCourse(course);
        return "redirect:/courses";
    }

    @GetMapping("/update/{id}")
    public String updateUser(@PathVariable("id") long id, Model model) {
        Course course = cS.getCourseById(id);
        model.addAttribute("course", course);
        return "Courses/editCourse";
    }

    @PostMapping("/update/{id}")
    public String updateUser(@ModelAttribute("course") Course course, @PathVariable("id") int id) {

        cS.editCourse(course, id);
        return "redirect:/courses";
    }
}
