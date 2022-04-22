package Dia14.EjerciosPropios14.Models;

import java.util.ArrayList;

public class Cart {
    private static int id;
    private int ownId;
    private ArrayList<Product> products;

    public Cart(){
        id++;
        ownId = id;
        products = new ArrayList<Product>();
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Cart.id = id;
    }

    public int getOwnId() {
        return ownId;
    }

    public void setOwnId(int ownId) {
        this.ownId = ownId;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "ownId=" + ownId +
                ", products=" + products +
                '}';
    }
}
