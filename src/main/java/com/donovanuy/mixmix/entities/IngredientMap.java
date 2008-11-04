package com.donovanuy.mixmix.entities;

import java.util.*;

import javax.persistence.*;

@Entity
@Table(name = "ingredient_map")
public class IngredientMap{

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long id;

@OneToOne
@JoinTable(name = "user_recipes_id")
private UserRecipe recipe;



}