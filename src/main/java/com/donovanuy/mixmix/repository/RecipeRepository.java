package com.donovanuy.mixmix.repository;

import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;

import com.donovanuy.mixmix.entities.Recipe;

public interface RecipeRepository extends JpaRepository<Recipe, String>{

    List<Recipe> findAll();

}