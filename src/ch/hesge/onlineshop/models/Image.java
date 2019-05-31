package ch.hesge.onlineshop.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class Image {

    @Id
    @GeneratedValue(strategy=IDENTITY)
    private int ID;
    private String urlImage;

    public Image(){

    }

    public Image(String urlImage){
        this.urlImage = urlImage;
    }

    public int getID() { return ID; }

    public String getUrlImage() {
        return urlImage;
    }
}
