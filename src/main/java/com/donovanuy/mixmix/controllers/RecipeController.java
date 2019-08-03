package com.donovanuy.mixmix.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

@Controller
public class RecipeController {
    
    @GetMapping("/recipe")
    public String recipe(@RequestParam(
                            name = "name",
                            required = false,
                            defaultValue= "Untitled")
                        String name, Model model)
                            {model.addAttribute("name", name);
                        return "recipe";
                    }
    
}