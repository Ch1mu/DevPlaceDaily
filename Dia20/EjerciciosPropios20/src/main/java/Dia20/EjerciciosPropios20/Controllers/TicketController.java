package Dia20.EjerciciosPropios20.Controllers;

import Dia20.EjerciciosPropios20.Models.Ticket;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("ticket")
public class TicketController {

    @GetMapping()
    public String getTicket(RedirectAttributes atributes)
    {
        return "TicketTemplates/TicketIndex";
    }

    @GetMapping("create/{id}")
    public String generate(@PathVariable("id") long id, RedirectAttributes atributes, Model model)
    {
        Ticket ticket = new Ticket();
        ticket.setGameId(id);
        atributes.addFlashAttribute("ticket", ticket);
        return "redirect:/ticket";
    }

}
