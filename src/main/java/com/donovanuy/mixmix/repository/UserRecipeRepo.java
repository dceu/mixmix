package com.donovanuy.mixmix.repository;

import com.donovanuy.mixmix.entities.UserRecipe;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRecipeRepo extends JpaRepository<UserRecipe, Long>{
    
}