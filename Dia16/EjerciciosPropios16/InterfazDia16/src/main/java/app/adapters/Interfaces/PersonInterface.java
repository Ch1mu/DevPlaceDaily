package app.adapters.Interfaces;

import app.models.Person;
import kong.unirest.HttpResponse;

import java.util.ArrayList;


public interface PersonInterface {
    public HttpResponse<String> getPersons();
    public HttpResponse getbyDni(String dni);
    public HttpResponse findVoted(boolean voted);
    public void editPerson(Person person, Long id);
    public void addPerson(Person person);
    public void deletePerson(Long id);

}
