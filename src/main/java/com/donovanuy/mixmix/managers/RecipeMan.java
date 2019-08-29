package com.donovanuy.mixmix.managers;

import java.util.*;

import com.donovanuy.mixmix.entities.*;
import com.donovanuy.mixmix.repository.RecipeRepository;
import com.donovanuy.mixmix.repository.UserRecipeRepo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Service
@Transactional
public class RecipeMan{
    



    @Autowired
    private UserRecipeRepo userRecipeRepo;

    public List<UserRecipe> listAllUserRecipes(){
        return userRecipeRepo.findAll();
    }

    public Page<UserRecipe> listAllUserRecipes(Pageable pageable){
        return userRecipeRepo.findAll(pageable);
    }

    public UserRecipe saveUserRecipe(UserRecipe ur){
        return userRecipeRepo.save(ur);
    }

    public UserRecipe findUserRecipeById(Long l){
        return userRecipeRepo.findById(l).get();
    }

    public void deleteUserRecipe(Long l){
        userRecipeRepo.deleteById(l);
    }

    // master repo actions
    
    @Autowired
    private RecipeRepository masterRepo;

    public List<Recipe> listAll() {
        return masterRepo.findAll();
    }

    public void save(Recipe recipe){
        masterRepo.save(recipe);
    }

    public Recipe get(String s){
        return masterRepo.findById(s).get();
    }

    public void delete(String s){
        masterRepo.deleteById(s);
    }


    // private Recipe newTitledRecipe(String s){
    //     return new Recipe(s);
    // }

    // private Recipe newUntitledRecipe(){
    //    return new Recipe("Untitled");
    // }

    
}