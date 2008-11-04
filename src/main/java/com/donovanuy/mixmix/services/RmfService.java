package com.donovanuy.mixmix.services;

import com.donovanuy.mixmix.entities.*;
import com.donovanuy.mixmix.recipemaker.RecipeMakerForm;
import com.donovanuy.mixmix.services.*;
import com.donovanuy.mixmix.recipemaker.RecipeMakerForm.ingredientRow;
import com.donovanuy.mixmix.recipemaker.RecipeMakerForm.prepRow;
import com.donovanuy.mixmix.repository.*;
import com.donovanuy.mixmix.managers.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

import javax.transaction.Transactional;


@Service
@Transactional
public class RmfService{

    @Autowired
    private UserServiceImpl us;

    @Autowired 
    private IngredientRepository pantry;

    @Autowired
    private RecipeMan recipeMan;


    public void createRecipeFromForm (RecipeMakerForm rmf){
        UserRecipe createdRecipe = new UserRecipe();
        createdRecipe.setTitle(rmf.getTitle());
        createdRecipe.setDescription(rmf.getDescription());
        createdRecipe.setGlass(rmf.getGlass());
        User user = us.findByUsername(rmf.getUser());

        StringBuilder prepBuild = new StringBuilder();
        int prepCount = 0;
        for( prepRow instruction : rmf.getPreparation()){
            prepCount ++;
            prepBuild.append(prepCount + " " + instruction.getInstruction() + "  //");
        }
        createdRecipe.setPreparation(prepBuild.toString());

        int ingredientCount = 0;
        for(ingredientRow row : rmf.getIngredientRows()){
            ingredientCount ++;
            if (pantry.findByName(row.getIngredient()) != null){
            Ingredient ingredient = pantry.findByName(row.getIngredient());
            // ingredient.getMeasures().add(Double.parseDouble(row.getMeasure()));
            // ingredient.getUnits().add(row.getUnit());
            createdRecipe.addIngredient(ingredient);
            } else {
            Ingredient ingredient = new Ingredient();
            ingredient.setName(row.getIngredient());
            // ingredient.getMeasures().add(Double.parseDouble(row.getMeasure()));
            // ingredient.getUnits().add(row.getUnit());
            createdRecipe.addIngredient(ingredient);
            }
            
        }

        recipeMan.saveUserRecipe(createdRecipe);
    }
}