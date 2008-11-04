package com.donovanuy.mixmix.recipemaker;

import java.util.*;
import com.donovanuy.mixmix.entities.*;
import javax.measure.*;

public class RecipeMakerForm{
    private String glass;
    private String title;
    private String description;
    private List<ingredientRow> ingredientRows = new ArrayList<ingredientRow>();
    private List<prepRow> preparation;
    private String user;

    public RecipeMakerForm(){
        // this.ingredientRows.add(new Row("Water","1","CL"));
    }

    public static class ingredientRow{
        public ingredientRow(){};

        public ingredientRow(String ingredient, String measure, String unit){
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

    public static class prepRow{
        public prepRow(){};

        public prepRow(String instruction){
            this.instruction = instruction;
        }

        private String instruction;

        @Override 
        public String toString(){
            return instruction;
        }

        public void setInstruction(String s){
            this.instruction = s;
        }

        public String getInstruction(){
            return instruction;
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

    public List<ingredientRow> getIngredientRows() {
        return this.ingredientRows;
    }

    public void setIngredientRows(List<ingredientRow> ingredientRows) {
        this.ingredientRows = ingredientRows;
    }

    public List<prepRow> getPreparation() {
        return this.preparation;
    }

    public void setPreparation(List<prepRow> preparation) {
        this.preparation = preparation;
    }

    public String getUser(){
        return this.user;
    }

    public void setUser(String user){
        this.user = user;

    }
    



}