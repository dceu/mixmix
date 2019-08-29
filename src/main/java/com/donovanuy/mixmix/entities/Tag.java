package com.donovanuy.mixmix.entities;

import java.util.*;

import javax.persistence.*;

@Entity
@Table(name = "tags")
public class Tag {

    @Column(name = "name")
    private String name;

    @Id
    @GeneratedValue
    private long id;

    @ManyToMany
    Set<Ingredient> ingredients;


    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Set<Ingredient> getIngredients() {
        return this.ingredients;
    }

    public void setIngredients(Set<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }
    
}