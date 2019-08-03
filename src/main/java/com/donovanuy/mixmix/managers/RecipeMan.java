package com.donovanuy.mixmix.managers;

import com.donovanuy.mixmix.entities.*;

public class RecipeMan{
    RecipeMan(){}

    private RecipeMan instance = new RecipeMan();

    public RecipeMan getInstance(){
        return instance;
    }

    private Recipe newTitledRecipe(String s){
        return new Recipe(s);
    }

    private Recipe newUntitledRecipe(){
       return new Recipe("Untitled");
    }

    
}