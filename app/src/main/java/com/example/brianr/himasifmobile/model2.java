package com.example.brianr.himasifmobile;

/**
 * Created by Brian R on 01/01/2018.
 */

public class model2 {
    private int id;
    private String text,image;

    public model2(int id, String image, String text) {
        this.id = id;
        this.image = image;
        this.text = text;
    }
    public model2(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
