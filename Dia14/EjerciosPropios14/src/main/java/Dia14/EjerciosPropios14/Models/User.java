package Dia14.EjerciosPropios14.Models;

public class User {
    private String firstName;
    private String surName;
    private String dni;
    Cart cart;

    public User(String firstName, String surName, String dni, Cart cart) {
        this.firstName = firstName;
        this.surName = surName;
        this.dni = dni;
        this.cart = cart;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
}
