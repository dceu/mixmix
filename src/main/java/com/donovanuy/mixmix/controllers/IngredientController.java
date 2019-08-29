package com.donovanuy.mixmix.controllers;

import java.util.*;

import com.donovanuy.mixmix.repository.IngredientRepository;

import javax.persistence.Id;


import com.donovanuy.mixmix.entities.Ingredient;
import com.donovanuy.mixmix.entities.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.springframework.http.ResponseEntity;

@Controller
@RequestMapping(path="/ingredients")
public class IngredientController {
    
    @Autowired
    IngredientRepository ingredientRepository;

    @GetMapping("/")
    public String viewPantry(Model model){
        List<Ingredient> listIngredients = ingredientRepository.findAll();
        model.addAttribute("listIngredients", listIngredients);
        return "pantry";
    }

    // @PostMapping("/ingredient")
    // public Ingredient create(@RequestBody Map<String, String> body){
    //     String name = body.get("name");
    //     String description = body.get("description");
    //     return ingredientRepository.save(new Ingredient(name, description));
    // }
    @RequestMapping("/ingredient/new")
    public String createNewIngredient(Model model){
        Ingredient ingredient = new Ingredient();
        model.addAttribute("ingredient", ingredient);
        return "new-ingredient";
    }

    @RequestMapping(value = "/ingredient/new/save", method = RequestMethod.POST)
    public String saveIngredient(@ModelAttribute("ingredient") Ingredient ingredient){
        ingredientRepository.save(ingredient);
        return "redirect:../../";
    }

    @GetMapping("/ingredient/{id}")
    public String show(@PathVariable String id, Model model){
        
        Integer ingredId = Integer.parseInt(id);
        Long l = ingredId.longValue();
        model.addAttribute("ingredient", ingredientRepository.getOne(l));
        return "ingredient";
    }

    @DeleteMapping("/ingredient/{ingredientId}")
    public String deleteIngredient(@PathVariable long ingredientId){
            
            ingredientRepository.deleteById(ingredientId);
            return "redirect:../";
    }

    
}