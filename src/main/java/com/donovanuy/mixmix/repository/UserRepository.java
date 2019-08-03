package com.donovanuy.mixmix.repository;

import org.springframework.data.repository.CrudRepository;

import com.donovanuy.mixmix.entities.User;

public interface UserRepository extends CrudRepository<User, Integer> {

}