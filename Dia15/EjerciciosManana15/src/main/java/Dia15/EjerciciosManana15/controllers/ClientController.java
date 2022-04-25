package Dia15.EjerciciosManana15.controllers;

import Dia15.EjerciciosManana15.services.ClientService;
import Dia15.EjerciciosManana15.models.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@CrossOrigin
@RequestMapping("/client")
public class ClientController {
    @Autowired
    ClientService cS;

    @GetMapping()
    public ArrayList<Client> getClients(){
        return cS.getClients();
    }
    @PostMapping()
    public Client saveClient(@RequestBody Client client)
    {
        return cS.saveClient(client);
    }

}
