package com.donovanuy.mixmix.entities;

import java.util.*;

import javax.persistence.*;

@Entity
@Table(name = "ingredients_master")
public class Ingredient extends AuditModel{

    @Column(name = "ingredient")
    private String name;
    @Column(name="description")
    private String description;

    @Id
    @GeneratedValue
    private long id;
    
    // public Ingredient(String n, String d){
    //     this.setName(n);
    //     this.setDescription(d);
    // }

    // public Ingredient(int id, String n, String d){
    //     this.setId(id);
    //     this.setName(n);
    //     this.setDescription(d);
    // }


    @ManyToMany(mappedBy = "ingredients")
    Set<UserRecipe> recipes;

    @ManyToMany
    Set<Tag> tags;

    
    // Set<Double> measures = new HashSet<Double>();

    
    // Set<String> units = new HashSet<String>();



// Setters

    public Set<UserRecipe> getRecipes() {
        return this.recipes;
    }

    public void setRecipes(Set<UserRecipe> recipes) {
        this.recipes = recipes;
    }


    public Set<Tag> getTags(){
        return this.tags;
    }

    public void setTags(Set<Tag> tags){
        this.tags = tags;
    }


    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }


    // public Set<Double> getMeasures() {
    //     return this.measures;
    // }

    // public void setMeasures(Set<Double> measures) {
    //     this.measures = measures;
    // }

    // public Set<String> getUnits() {
    //     return this.units;
    // }

    // public void setUnits(Set<String> units) {
    //     this.units = units;
    // }
    

}