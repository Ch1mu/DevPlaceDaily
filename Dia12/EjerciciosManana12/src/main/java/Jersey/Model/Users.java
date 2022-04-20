package Jersey.Model;

public class Users {
    private int id;
    private String name;
    private String lastName;
    private String dni;

    public Users(int id, String name, String lastName, String dni){
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.dni = dni;
    }
    public Users(String name, String lastName, String dni){

        this.name = name;
        this.lastName = lastName;
        this.dni = dni;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }
}
