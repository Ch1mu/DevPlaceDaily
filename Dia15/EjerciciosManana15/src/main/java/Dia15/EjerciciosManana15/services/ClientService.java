package Dia15.EjerciciosManana15.services;

import Dia15.EjerciciosManana15.repositories.ClientRepository;
import Dia15.EjerciciosManana15.models.Client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ClientService {
    @Autowired
    ClientRepository cR;
    public ArrayList<Client> getClients()
    {
        return (ArrayList<Client>) cR.findAll();
    }
    public Client saveClient(Client client){
        return cR.save(client);
    }
}
