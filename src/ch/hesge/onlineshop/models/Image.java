package ch.hesge.onlineshop.models;

import java.util.UUID;

public class Image {
    private UUID ID = UUID.randomUUID();
    private String urlImage;

    public Image(String urlImage){
        this.urlImage = urlImage;
    }

    public UUID getID() { return ID; }

    public String getUrlImage() {
        return urlImage;
    }
}
