package ch.hesge.onlineshop.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import java.util.Objects;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private int ID;
    private String name;
    private Double price;
    private String urlImage;

    @Column(length = 9000)
    private String description;

    public Product() {
    }

    public Product(String name, Double price, String urlImage, String description) {
        this.name = name;
        this.price = price;
        this.urlImage = urlImage;
        this.description = description;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(ID, product.ID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID);
    }
}
