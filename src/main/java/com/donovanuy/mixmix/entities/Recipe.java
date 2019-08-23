package com.donovanuy.mixmix.entities;



import javax.persistence.*;

import java.util.*;

@Entity(name="recipe")
@Table(name="cocktails_master")
public class Recipe {

    @Id
    @Column(name="name")
    private String name;

    
    @Column(name="RecipeId")
    private Long RecipeId;
    
    @Column(name = "description")
    private String description;
    //private List<Ingredient> ingredientList;
    @Column(name = "ingredients")
    private String ingredients;

    @Column(name = "preparation")
    private String preparation;

    @Column(name = "tags")
    private String tags;

    @Column(name = "complete")
    private String complete;

    @Column(name = "img")
    private String img;

 


    // Setters 


    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getRecipeId() {
        return this.RecipeId;
    }

    public void setRecipeId(Long id) {
        this.RecipeId = id;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public String getIngredients() {
        return this.ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getPreparation() {
        return this.preparation;
    }

    public void setPreparation(String preparation) {
        this.preparation = preparation;
    }

    public String getTags() {
        return this.tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getComplete() {
        return this.complete;
    }

    public void setComplete(String complete) {
        this.complete = complete;
    }

    public String getImg() {
        return this.img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    // public List<Ingredient> getIngredientList() {
    //     return this.ingredientList;
    // }

    // public void setIngredientList(List<Ingredient> ingredientList) {
    //     this.ingredientList = ingredientList;
    // }





  
    
    
}

