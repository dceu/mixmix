package com.donovanuy.mixmix.controllers;

import com.donovanuy.mixmix.entities.*;
import com.donovanuy.mixmix.repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class CommentController{
    
    @Autowired 
    private CommentRepo commentRepo;

    @Autowired
    private UserRecipeRepo userRecipeRepo;

    @GetMapping("/userRecipes/{userRecipeId}/comments")
    public Page<Comment> getAllCommentsByRecipeId(@PathVariable (value = "userRecipeId") Long userRecipeId,
                                                    Pageable pageable){
        return commentRepo.findByUserRecipeId(userRecipeId, pageable);
    }

    @PostMapping("/userRecipes/{userRecipeId}/comments")
    public Comment createComment(@PathVariable (value = "userRecipeId") Long userRecipeId,
                                @Valid @RequestBody Comment comment) {
        return userRecipeRepo.findById(userRecipeId).map(userRecipe -> {
            comment.setUserRecipe(userRecipe);
            return commentRepo.save(comment);
        }).orElseThrow(() -> new ResourceNotFoundException("UserRecipeId " + userRecipeId + " not Found"));
        }

    @PutMapping("/userRecipes/{userRecipeId}/comments/{commentId}")
    public Comment updateComment(@PathVariable (value = "userRecipeId") Long userRecipeId,
                                @PathVariable (value = "commentId") Long commentId,
                                @Valid @RequestBody Comment commentRequest) {
        if(!userRecipeRepo.existsById(userRecipeId)){
                throw new ResourceNotFoundException("Recipe Id " + userRecipeId + " not found!");
        }

        return commentRepo.findById(commentId).map(comment -> {
            comment.setText(commentRequest.getText());
            return commentRepo.save(comment);

        }).orElseThrow(() -> new ResourceNotFoundException("Comment Id" + commentId + " not found"));
    }

    @DeleteMapping("/userRecipes/{userRecipeId}/comments/{commentId}")
    public ResponseEntity<?> deleteComment(@PathVariable (value = "userRecipeId") Long userRecipeId,
                                            @PathVariable (value ="commentId") Long commentId){
        return commentRepo.findByIdAndUserRecipeId(commentId, userRecipeId).map(comment -> {
            commentRepo.delete(comment);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("Comment not found with id " + commentId + " and post Id " + userRecipeId));
    }
}