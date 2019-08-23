package com.donovanuy.mixmix.managers;

import java.util.*;

import com.donovanuy.mixmix.entities.*;
import com.donovanuy.mixmix.repository.RecipeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RecipeMan{
    


    @Autowired
    private RecipeRepository repo;

    public List<Recipe> listAll() {
        return repo.findAll();
    }

    public void save(Recipe recipe){
        repo.save(recipe);
    }

    public Recipe get(String s){
        return repo.findById(s).get();
    }

    public void delete(String s){
        repo.deleteById(s);
    }


    // private Recipe newTitledRecipe(String s){
    //     return new Recipe(s);
    // }

    // private Recipe newUntitledRecipe(){
    //    return new Recipe("Untitled");
    // }

    
}