package com.donovanuy.mixmix.recipemaker;

import java.util.*;
import com.donovanuy.mixmix.entities.*;
import javax.measure.*;

public class RecipeMakerForm{
    private String glass;
    private String title;
    private String description;
    private List<Row> ingredientRows = new ArrayList<Row>();
    private String preparation;

    public RecipeMakerForm(){
        // this.ingredientRows.add(new Row("Water","1","CL"));
    }

    public static class Row{
        public Row(){};

        public Row(String ingredient, String measure, String unit){
            this.ingredient = ingredient;
            this.measure = measure;
            this.unit = unit;
        }

        private String ingredient;
        private String measure;
        private String unit;

        @Override
        public String toString(){
            return  measure + " " + unit + " " + ingredient ;
        }

        public String getIngredient(){
            return this.ingredient;
        }

        public String getMeasure(){
            return this.measure;
        }

        public String getUnit(){
            return this.unit;
        }

        public void setIngredient(String i){
            this.ingredient = i;
        }

        public void setMeasure(String m){
            this.measure = m;
        }

        public void setUnit(String u){
            this.unit = u;
        }
        
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

    public List<Row> getIngredientRows() {
        return this.ingredientRows;
    }

    public void setIngredientRows(List<Row> ingredientRows) {
        this.ingredientRows = ingredientRows;
    }

    public String getPreparation() {
        return this.preparation;
    }

    public void setPreparation(String preparation) {
        this.preparation = preparation;
    }



}