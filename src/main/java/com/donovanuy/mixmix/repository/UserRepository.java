package com.donovanuy.mixmix.repository;

//import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.JpaRepository;


import com.donovanuy.mixmix.entities.User;
import java.util.List;


public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> findAllById(Integer id);
    User findByUsername(String username);
}