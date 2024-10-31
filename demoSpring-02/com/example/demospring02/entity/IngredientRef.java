package com.example.demospring02.entity;

import java.io.Serializable;

/**
 * ingredient_ref
 * @author 
 */
public class IngredientRef implements Serializable {
    private String ingredient;

    private String taco;

    private String tacoKey;

    private static final long serialVersionUID = 1L;

    public String getIngredient() {
        return ingredient;
    }

    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }

    public String getTaco() {
        return taco;
    }

    public void setTaco(String taco) {
        this.taco = taco;
    }

    public String getTacoKey() {
        return tacoKey;
    }

    public void setTacoKey(String tacoKey) {
        this.tacoKey = tacoKey;
    }
}