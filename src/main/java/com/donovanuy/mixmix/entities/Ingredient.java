package com.donovanuy.mixmix.entities;

import java.util.*;

import javax.persistence.*;

@Entity
@Table(name="pantry")
public class Ingredient{

    @Column(name = "ingredient")
    private String name;
    @Column(name="description")
    private String description;

    @Id
    @GeneratedValue
    @Column(name="IngredientID")
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
// Setters


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


}