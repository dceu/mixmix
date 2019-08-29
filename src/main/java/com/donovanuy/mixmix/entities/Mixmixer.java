package com.donovanuy.mixmix.entities;

import java.util.*;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import javax.persistence.*;

import javax.validation.constraints.*;

@EntityListeners(AuditingEntityListener.class)
@Entity
@Table(name = "mixmixers")
public class Mixmixer extends AuditModel {

    // User Fields

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    @NotNull
    @Size(min=2, max=30)
    private String name;

    @NotNull
    @Min(21)
    private Integer age;

    @NotNull
    @Email
    private String email;

    //



    
    @Column(name = "createdRecipes")
    UserRecipe createdRecipes;

   
    @Column(name ="favorited")
    UserRecipe favorited;



    public UserRecipe getCreatedRecipes() {
        return this.createdRecipes;
    }

    public void setCreatedRecipes(UserRecipe createdRecipes) {
        this.createdRecipes = createdRecipes;
    }

    public UserRecipe getFavorited() {
        return this.favorited;
    }

    public void setFavorited(UserRecipe favorited) {
        this.favorited = favorited;
    }

    

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return this.age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    
}