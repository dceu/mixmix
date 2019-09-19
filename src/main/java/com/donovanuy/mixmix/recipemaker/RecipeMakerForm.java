package com.donovanuy.mixmix.recipemaker;

import java.util.*;
import com.donovanuy.mixmix.entities.*;
import javax.measure.*;

public class RecipeMakerForm{
    private String glass;
    private String title;
    private String description;
    private Set<Row> ingredientRows;
    private String preparation;

    private class Row{
        public Row(){};

        private String ingredient;
        private String measure;
        private String unit;
        
    }

    // Getters & Setters

    public String getGlass() {
        return this.glass;
    }

    public void setGlass(String glass) {
        this.glass = glass;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Row> getIngredientRows() {
        return this.ingredientRows;
    }

    public void setIngredientRows(Set<Row> ingredientRows) {
        this.ingredientRows = ingredientRows;
    }

    public String getPreparation() {
        return this.preparation;
    }

    public void setPreparation(String preparation) {
        this.preparation = preparation;
    }



}