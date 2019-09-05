package com.donovanuy.mixmix.services;

import com.donovanuy.mixmix.entities.*;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}