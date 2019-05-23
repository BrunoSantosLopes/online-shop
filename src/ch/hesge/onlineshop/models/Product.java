package ch.hesge.onlineshop.models;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class Product {

    private UUID ID;
    private String name;
    private Double price;
    private Image mainImage;
    private List<Image> images;
    private String description;

    public Product (UUID ID, String name, Double price, Image mainImage, List<Image> images, String description){
        this.ID = ID;
        this.name = name;
        this.price = price;
        this.mainImage = mainImage;
        this.description = description;
        this.images = images;
    }

    public UUID getID() { return ID; }
    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }
    public Image getMainImage() {
        return mainImage;
    }
    public List<Image> getImages() { return images; }
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
