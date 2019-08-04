package com.donovanuy.mixmix.entities;

import java.util.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Ingredient{
    private String name;
    private String description;

    @Id
    @GeneratedValue
    private int id;
    
    public Ingredient(String n, String d){
        this.setName(n);
        this.setDescription(d);
    }

    public Ingredient(int id, String n, String d){
        this.setId(id);
        this.setName(n);
        this.setDescription(d);
    }
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

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }


}