package com.example.demo.models;


import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "informacion")
public class InformacionModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;



    private Long userId;
    private String telefono;
    private String direccion;
    private int edad;
    private Date fechaNacimiento;

  public String getTelefono() {
  	return this.telefono;
  }
  public Long getUserId() {
    return userId;
}
public void setUserId(Long userId) {
    this.userId = userId;
}
public void setTelefono(String telefono) {
  	this.telefono = telefono;
  }


    public String getDireccion() {
    	return this.direccion;
    }
    public void setDireccion(String direccion) {
    	this.direccion = direccion;
    }


    public int getEdad() {
    	return this.edad;
    }
    public void setEdad(int edad) {
    	this.edad = edad;
    }


    public Date getFechaNacimiento() {
    	return this.fechaNacimiento;
    }
    public void setFechaNacimiento(Date fechaNacimiento) {
    	this.fechaNacimiento = fechaNacimiento;
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }

  

 


 
    
}
