package DevPlace22.mvcPropio22.Controllers;

import DevPlace22.mvcPropio22.Controllers.ports.PersonPort;
import DevPlace22.mvcPropio22.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/persons")
public class PersonController {

    @Autowired
    private PersonPort pP;

    @GetMapping
    public String getAll(Model model)
    {
        model.addAttribute("persons", pP.getPersons());
        return "PersonTemplates/index";
    }

    @GetMapping("/save")
    public String savePerson(Model model) {
      Person p = new Person();
      model.addAttribute("person", p);
        return "PersonTemplates/PersonCreate";
    }

    @PostMapping("/save")
    public String addPerson(@ModelAttribute("person") Person person) {
       pP.addperson(person);
        return "redirect:/persons";
    }

    @GetMapping("/filter")
    public String filter(Model model) {
        String dni = "";
        model.addAttribute("dni", dni);
        return "PersonTemplates/FilterByDni";
    }

    @PostMapping("/filter")
    public String filterByDni(@RequestParam("dni") String dni, Model model) {

        model.addAttribute("persons", pP.getPersonsByDni(dni));
        return "PersonTemplates/Index";
    }


}
