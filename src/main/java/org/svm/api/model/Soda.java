package org.svm.api.model;

import java.util.Objects;

public class Soda {
    private int id;
    private String name;
    private float price;
    private int quantity;

    public Soda(int id, String name, float price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
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

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Soda{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Soda)) return false;
        Soda soda = (Soda) o;
        return id == soda.id &&
                Float.compare(soda.price, price) == 0 &&
                quantity == soda.quantity &&
                Objects.equals(name, soda.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, price, quantity);
    }
}
