package com.donovanuy.mixmix.controllers;

import java.util.Map;

import com.donovanuy.mixmix.repository.IngredientRepository;

import javax.persistence.Id;


import com.donovanuy.mixmix.entities.Ingredient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path="/pantry")
public class IngredientController {
    
    @Autowired
    IngredientRepository ingredientRepository;

    @PostMapping("/ingredient")
    public Ingredient create(@RequestBody Map<String, String> body){
        String name = body.get("name");
        String description = body.get("description");
        return ingredientRepository.save(new Ingredient(name, description));
    }
    

    @GetMapping("/ingredient/{id}")
    public Ingredient show(@PathVariable String id){
        
        int ingredId = Integer.parseInt(id);
        return ingredientRepository.getOne(ingredId);
    }

    
}