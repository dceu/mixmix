package com.donovanuy.mixmix.controllers;


import java.util.*;

import com.donovanuy.mixmix.managers.*;
import com.donovanuy.mixmix.entities.*;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;


@Controller
@RequestMapping("/recipes")
public class RecipeController {

    @Autowired
    private RecipeMan recipeMan;

    @GetMapping("/all")
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
    
}