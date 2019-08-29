package com.donovanuy.mixmix.controllers;


import java.util.*;

import com.donovanuy.mixmix.managers.*;
import com.donovanuy.mixmix.repository.IngredientRepository;
import com.donovanuy.mixmix.repository.UserRecipeRepo;
import com.donovanuy.mixmix.entities.*;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import net.bytebuddy.implementation.bind.MethodDelegationBinder.BindingResolver;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;


@Controller
@RequestMapping("/recipes")
public class RecipeController {

    @Autowired
    private RecipeMan recipeMan;

    @Autowired
    private UserRecipeRepo userRecipeRepo;

    @Autowired
    private IngredientRepository ingredientRepo;


    @GetMapping("/")
    public String viewAllRecipes(Model model){
        List<Recipe> listRecipes = recipeMan.listAll();
        Iterator<Recipe> itr = listRecipes.iterator();
        while (itr.hasNext()){
            Recipe r = itr.next();
            if (r.getComplete().equals("FALSE")){
                itr.remove();
            }
        }
        model.addAttribute("listRecipes", listRecipes);
        return "recipe-index";
    }

    @GetMapping("/allJSON")
    public @ResponseBody Iterable<Recipe> getAllRecipess() {
        return recipeMan.listAll();
        
        // for(Recipe r: listRecipes){
        //     System.out.println(r.getName());
        //     if (r.getComplete().equals("FALSE")){
        //     listRecipes.remove(r);
        //     System.out.println("removed "+ r.getName() + " from viewList" );
        //     }
        // }

        // model.addAttribute("listRecipes", listRecipes);

        // return "recipe-index";
    }
    

    //User Recipe Actions

    @GetMapping("/userRecipes")
    public Page<UserRecipe> getAllUserRecipes(Pageable pageable){
        return recipeMan.listAllUserRecipes(pageable);
    }

    @PostMapping("/userRecipes")
    public UserRecipe createRecipe(@Valid @RequestBody UserRecipe ur){
        return recipeMan.saveUserRecipe(ur);
    }

    @RequestMapping("/userRecipes/new")
    public String createNewUserRecipe(Model model){
        UserRecipe userRecipe = new UserRecipe();
        model.addAttribute("userRecipe", userRecipe);
        return "new-recipe";
    }

    @RequestMapping(value = "/userRecipes/new/save", method = RequestMethod.POST)
    public String saveRecipe(
        @Valid
        @RequestBody UserRecipe userRecipe,
        @RequestParam(value = "sel_ingredients", required = false) long[] sel_ingredients,
        BindingResult bindingResult, Model model){
        // for(long l : sel_ingredients){
        //     Ingredient ing = new Ingredient();
        //     ing = ingredientRepo.getOne(l);
        //     userRecipe.addIngredient(ing);
        // }
        userRecipeRepo.save(userRecipe);
        return "redirect:../";
    }



    @ModelAttribute
    public void populateIngredients(Model model){
        List<Ingredient> ingredientList = this.ingredientRepo.findAll();
        //Iterator<Ingredient> itr = ingredientList.iterator();
        model.addAttribute("allIngredients", ingredientList);
        
    }

    @PutMapping("/userRecipes/{userRecipeId}")
    public UserRecipe updateUserRecipe(@PathVariable Long userRecipeId, @Valid @RequestBody UserRecipe postRequest){
        return userRecipeRepo.findById(userRecipeId).map( userRecipe -> {
            userRecipe.setTitle(postRequest.getTitle());
            userRecipe.setDescription(postRequest.getDescription());
            userRecipe.setIngredients(postRequest.getIngredients());
            userRecipe.setPreparation(postRequest.getPreparation());
            return userRecipeRepo.save(userRecipe);
        }).orElseThrow(() -> new ResourceNotFoundException("UserRecipeId " + userRecipeId + " not found"));  
    }

    @DeleteMapping("/userRecipes/{userRecipeId}")
    public ResponseEntity<?> deleteRecipe(@PathVariable Long userRecipeId){
        return userRecipeRepo.findById(userRecipeId).map(userRecipe -> {
            userRecipeRepo.delete(userRecipe);
            return ResponseEntity.ok().build();
       }).orElseThrow(() -> new ResourceNotFoundException("UserRecipeId " + userRecipeId + " not found"));
    }

}