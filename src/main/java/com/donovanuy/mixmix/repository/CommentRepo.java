package com.donovanuy.mixmix.repository;

import com.donovanuy.mixmix.entities.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.*;


@Repository
public interface CommentRepo extends JpaRepository<Comment, Long>{
    Page<Comment> findByUserRecipeId(Long userRecipeId, Pageable pageable);
    Optional<Comment> findByIdAndUserRecipeId(Long id, Long userRecipeId);
}