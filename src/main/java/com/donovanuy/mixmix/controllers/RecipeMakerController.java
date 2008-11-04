package com.donovanuy.mixmix.controllers;

import java.util.*;

import com.donovanuy.mixmix.managers.*;
import com.donovanuy.mixmix.recipemaker.RecipeMakerForm;
import com.donovanuy.mixmix.recipemaker.RecipeMakerForm.ingredientRow;
import com.donovanuy.mixmix.recipemaker.RecipeMakerForm.prepRow;
import com.donovanuy.mixmix.repository.*;
import com.donovanuy.mixmix.services.RmfService;
import com.donovanuy.mixmix.entities.*;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@RequestMapping("/recipeMaker")
public class RecipeMakerController{

    @Autowired
    private IngredientRepository ingredientRepo;

    @Autowired
    private RmfService rmfService;
    
    @ModelAttribute
    public void formModel(Model model){
        RecipeMakerForm rmf = new RecipeMakerForm();
        

        List<Ingredient> allIngredients = this.ingredientRepo.findAll();

        Set<String> glassware= new HashSet<String>();
        for(Glass g: EnumSet.allOf(Glass.class)) {
            glassware.add(g.name());
        }

        Set<String> units = new HashSet<String>();
        for(Unit u: EnumSet.allOf(Unit.class)) {
            units.add(u.name());
        }

        model.addAttribute("recipeMakerForm", rmf);
        model.addAttribute("glassware", glassware);
        model.addAttribute("allIngredients", allIngredients);
        model.addAttribute("units", units);

    }

    @GetMapping("/")
    public String viewForm(Model model){

        return "recipe-maker-form";
    }

    @RequestMapping(value="/", params={"addRow"})
    public String addRow(final RecipeMakerForm recipeMakerForm, final BindingResult bindingResult){
        recipeMakerForm.getIngredientRows().add(new ingredientRow());
        return "recipe-maker-form";
    }

    @RequestMapping(value = "/", params={"removeRow"})
    public String removeRow(
        final RecipeMakerForm recipeMakerForm, final BindingResult bindingResult,
        final HttpServletRequest req){
            final Integer rowId = Integer.valueOf(req.getParameter("removeRow"));
            recipeMakerForm.getIngredientRows().remove(rowId.intValue());
            return "recipe-maker-form";
    }

    @RequestMapping(value="/", params={"addPrepRow"})
    public String addPrepRow(final RecipeMakerForm recipeMakerForm, final BindingResult bindingResult){
        recipeMakerForm.getPreparation().add(new prepRow());
        return "recipe-maker-form";
    }

    @RequestMapping(value="/", params={"removePrepRow"})
    public String removePrepRow(
        final RecipeMakerForm recipeMakerForm, final BindingResult bindingResult,
        final HttpServletRequest req){
            final Integer rowId = Integer.valueOf(req.getParameter("removePrepRow"));
            recipeMakerForm.getPreparation().remove(rowId.intValue());
            return "recipe-maker-form";
    }
    
    @RequestMapping(value="/", params={"save"})
    public String save(@ModelAttribute("recipeMakerForm") RecipeMakerForm resultsForm, Model model){
        rmfService.createRecipeFromForm(resultsForm);
        model.addAttribute("resultsForm", resultsForm);
        return "recipe-maker-results";
    }

    
}
