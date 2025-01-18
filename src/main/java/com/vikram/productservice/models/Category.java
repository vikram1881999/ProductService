package com.vikram.productservice.models;

import jakarta.persistence.Entity;

@Entity( name = "categories")
public class Category extends BaseModel {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
