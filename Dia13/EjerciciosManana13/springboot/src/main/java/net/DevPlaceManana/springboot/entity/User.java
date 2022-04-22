package net.DevPlaceManana.springboot.entity;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.lang.NonNullApi;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "email")
	private String email;

	@Column(name = "dni")
	@ApiModelProperty(required = true)
	private int dni;
	
	public User() {
		
	}
	
	public User(String firstName, String lastName, String email, int dni) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.dni= dni;
	}
	
	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getDni() {
		return this.dni;
	}
	public void setDni(int dni) {
		this.dni = dni;
	}
}
