package com.donovanuy.mixmix.repository;

//import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.JpaRepository;


import com.donovanuy.mixmix.entities.Ingredient;
import java.util.List;


public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
    List<Ingredient> findAllById(Long id);
    Ingredient getOne(Long id);
    public void deleteById(Long Id);
}