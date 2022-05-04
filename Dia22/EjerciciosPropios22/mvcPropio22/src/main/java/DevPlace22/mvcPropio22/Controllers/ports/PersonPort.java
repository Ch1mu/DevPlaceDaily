package DevPlace22.mvcPropio22.Controllers.ports;

import DevPlace22.mvcPropio22.Controllers.adapters.PersonAdapter;

import DevPlace22.mvcPropio22.models.Person;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import kong.unirest.HttpResponse;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.ArrayList;

@Service
public class PersonPort {
PersonAdapter pA = new PersonAdapter();

    public ArrayList<Person> getPersons()
    {
        HttpResponse<String> httpResponse = pA.getPersons();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String data = gson.toJson(JsonParser.parseString(httpResponse.getBody()));
        Type userListType = new TypeToken<ArrayList<Person>>(){}.getType();

        return gson.fromJson(data, userListType);
    }



    public ArrayList<Person> getPersonsByDni(String dni)
    {
        HttpResponse<String> httpResponse = pA.getbyDni(dni);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String data = gson.toJson(JsonParser.parseString(httpResponse.getBody()));
        Type userListType = new TypeToken<ArrayList<Person>>(){}.getType();

        return gson.fromJson(data, userListType);
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
