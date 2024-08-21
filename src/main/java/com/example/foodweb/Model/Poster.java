package com.example.foodweb.Model;

import jakarta.persistence.*;
import jakarta.persistence.Id;

@Entity
@Table(name = "poster")
public class Poster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_image")
    private Integer idImage;
    @Column(name = "name_image")
    private String nameImage;
    private String image;

    // Getters and setters

    public Poster(){

    }
    public Poster(Integer idImage, String nameImage, String image) {
        this.idImage = idImage;
        this.nameImage = nameImage;
        this.image = image;
    }

    public Integer getIdImage() {
        return idImage;
    }

    public void setIdImage(Integer idImage) {
        this.idImage = idImage;
    }

    public String getNameImage() {
        return nameImage;
    }

    public void setNameImage(String nameImage) {
        this.nameImage = nameImage;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
