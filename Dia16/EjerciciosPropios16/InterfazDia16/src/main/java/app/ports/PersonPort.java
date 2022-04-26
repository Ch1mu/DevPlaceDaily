package app.ports;

import app.adapters.PersonAdapter;
import app.models.Person;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParser;
import kong.unirest.HttpResponse;

import java.util.ArrayList;

public class PersonPort {
PersonAdapter pA = new PersonAdapter();

    public void getPersons()
    {
        HttpResponse<String> httpResponse = pA.getPersons();

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        System.out.println(gson.toJson(JsonParser.parseString(httpResponse.getBody())));
    }
    public void getPersonsByDni(String dni)
    {
        HttpResponse<String> httpResponse = pA.getbyDni(dni);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        System.out.println(gson.toJson(JsonParser.parseString(httpResponse.getBody())));
    }
    public void findVoted(boolean voted)
    {
        HttpResponse<String> httpResponse = null;

            httpResponse = pA.findVoted(voted);


        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        System.out.println(gson.toJson(JsonParser.parseString(httpResponse.getBody())));
    }

    public void addperson(Person person)
    {
        pA.addPerson(person);
    }
    public void editPerson(Person person, Long id)
    {
        pA.editPerson(person, id);
    }
    public void deletePerson(Long id)
    {
        pA.deletePerson(id);
    }
}
