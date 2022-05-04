package DevPlace22.mvcPropio22.Controllers.adapters;


import DevPlace22.mvcPropio22.Controllers.adapters.Interfaces.PersonInterface;

import DevPlace22.mvcPropio22.models.Person;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import org.springframework.stereotype.Repository;


@Repository
public class PersonAdapter implements PersonInterface {

    Person p;
    @Override
    public HttpResponse<String> getPersons() {

        return  Unirest.get("http://localhost:8080/persons").asString();
    }


    @Override
    public HttpResponse getbyDni(String dni) {
        return  Unirest.get("http://localhost:8080/persons/findDni?dni=" + dni).asString();
    }

    @Override
    public HttpResponse findVoted(boolean voted) {

        return  Unirest.get("http://localhost:8080/persons/findVoted?voted=" + voted).asString();
    }

    @Override
    public void addPerson(Person person) {
        HttpResponse<JsonNode> response =   Unirest.post("http://localhost:8080/persons").body(person).asJson();
    }

    @Override
    public void deletePerson(Long id) {
        HttpResponse<JsonNode> response =  Unirest.delete("http://localhost:8080/persons/" +id).asJson();
    }
    @Override
    public void editPerson(Person person, Long id)
    {
        HttpResponse<JsonNode> response =   Unirest.post("http://localhost:8080/persons/edit/" + id).body(person).asJson();
    }
}
