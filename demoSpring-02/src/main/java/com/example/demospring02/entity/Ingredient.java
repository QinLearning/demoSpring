package com.example.demospring02.entity;

import java.io.Serializable;

/**
 * ingredient
 * @author 
 */
public class Ingredient implements Serializable {
    private String id;

    private String name;

    private String type;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}