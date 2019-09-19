package com.donovanuy.mixmix.controllers;

import java.util.*;

import com.donovanuy.mixmix.managers.*;
import com.donovanuy.mixmix.recipemaker.RecipeMakerForm;
import com.donovanuy.mixmix.repository.*;
import com.donovanuy.mixmix.entities.*;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;

import javax.validation.Valid;

@Controller
@RequestMapping("/recipeMaker")
public class RecipeMakerController{
    
    @ModelAttribute
    public void formModel(Model model){
        RecipeMakerForm rmf = new RecipeMakerForm();

        Set<String> glassware= new HashSet<String>();
        for(Glass g: EnumSet.allOf(Glass.class)) {
            glassware.add(g.name());
        }

        model.addAttribute("recipeMakerForm", rmf);
        model.addAttribute("glassware", glassware);

    }

    @GetMapping("/")
    public String viewForm(Model model){

        return "recipe-maker-form";
    }
}
