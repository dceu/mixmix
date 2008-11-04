package com.donovanuy.mixmix.entities;


import java.util.*;

import javax.persistence.*;
import javax.validation.constraints.*;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;



@Entity
@Table(name = "user_recipes")
public class UserRecipe extends  AuditModel{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 100)
    @Column(unique = true)
    private String title;

    @NotNull
    @Size(max = 250)
    private String description;

    private String glass;


    @ManyToMany
    @JoinTable(
        name = "used_ingred",
        joinColumns = @JoinColumn(name = "user_recipe_id"),
        inverseJoinColumns = @JoinColumn(name = "ingredientid")
    )
    private List<Ingredient> ingredients;

    
    
    @Lob
    private String preparation;

    // @ManyToOne(fetch = FetchType.LAZY, optional = false)
    // @JoinColumn(name = "mixmixer_id", nullable = false)
    // @OnDelete(action= OnDeleteAction.CASCADE)
    // private Mixmixer mixmixer;


 // setters and getters


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Ingredient> getIngredients() {
        return this.ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public void addIngredient(Ingredient i){
        this.ingredients.add(i);
    }

    public String getPreparation() {
        return this.preparation;
    }

    public void setPreparation(String preparation) {
        this.preparation = preparation;
    }

    public String getGlass(){
        return this.glass;
    }

    public void setGlass(String glass){
        this.glass = glass;
    }
}