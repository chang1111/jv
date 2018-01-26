package com.example.bbs.model;

import android.graphics.drawable.Drawable;

public class ModelPerson {
    private Drawable imagePhoto = null;  // ImageView
    private String   textName   = ""  ;  // TextView
    private String   textAge    = ""  ;  // TextView
    private Boolean  imageCheck = null;  // CheckBox

    public Drawable getImagePhoto() {
        return imagePhoto;
    }

    public void setImagePhoto(Drawable imagePhoto) {
        this.imagePhoto = imagePhoto;
    }

    public String getTextName() {
        return textName;
    }

    public void setTextName(String textName) {
        this.textName = textName;
    }

    public String getTextAge() {
        return textAge;
    }

    public void setTextAge(String textAge) {
        this.textAge = textAge;
    }

    public Boolean getImageCheck() {
        return imageCheck;
    }

    public void setImageCheck(Boolean imageCheck) {
        this.imageCheck = imageCheck;
    }

    @Override
    public String toString() {
        return "ModelPerson{" +
                "imagePhoto=" + imagePhoto +
                ", textName='" + textName + '\'' +
                ", textAge='" + textAge + '\'' +
                ", imageCheck=" + imageCheck +
                '}';
    }

    public ModelPerson() {
    }

    public ModelPerson(Drawable imagePhoto, String textName, String textAge, Boolean imageCheck) {
        this.imagePhoto = imagePhoto;
        this.textName = textName;
        this.textAge = textAge;
        this.imageCheck = imageCheck;
    }
}
