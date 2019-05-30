package ch.hesge.onlineshop.models;

import javax.persistence.*;
import java.util.Objects;


import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy=IDENTITY)
    private int ID;
    private String name;
    private Double price;
    @OneToOne(cascade = CascadeType.ALL)
    private Image image;

    @Column(length = 9000)
    private String description;

    public Product(){}

    public Product (String name, Double price, Image image, String description){
        this.name = name;
        this.price = price;
        this.image = image;
        this.description = description;
    }

    public int getID() { return ID; }
    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }
    public Image getImage() {
        return image;
    }

    public String getDescription() { return description; }
    public String getDescriptionHTML() { return description.replace("\n", "<br />\n"); }

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
