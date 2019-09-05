package com.donovanuy.mixmix.entities;

import java.util.*;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import javax.persistence.*;

import javax.validation.constraints.*;


@Entity
@Table(name = "users")
public class User {

    // User Fields

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @NotNull
    @Size(min=2, max=30)
    private String username;

    @NotNull
    @Min(21)
    private Integer age;

    @Column(name="email", unique= true)
    @NotNull
    @Email
    private String email;

    private String password;

    @Transient
    private String passwordConfirm;

    @ManyToMany
    @JoinTable(name = "user_role",
                joinColumns = @JoinColumn(name = "user_id"),
                inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    
    @Column(name = "createdRecipes")
    UserRecipe createdRecipes;

   
    @Column(name ="favorited")
    UserRecipe favorited;

    // setters and getters


    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordConfirm() {
        return this.passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    public Set<Role> getRoles() {
        return this.roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }


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

    

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
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