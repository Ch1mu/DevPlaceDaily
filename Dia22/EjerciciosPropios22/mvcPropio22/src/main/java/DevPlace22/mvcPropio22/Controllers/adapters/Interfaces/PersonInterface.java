package DevPlace22.mvcPropio22.Controllers.adapters.Interfaces;



import DevPlace22.mvcPropio22.models.Person;
import kong.unirest.HttpResponse;


public interface PersonInterface {
    public HttpResponse<String> getPersons();
    public HttpResponse getbyDni(String dni);
    public HttpResponse findVoted(boolean voted);
    public void editPerson(Person person, Long id);
    public void addPerson(Person person);
    public void deletePerson(Long id);

}
