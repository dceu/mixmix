package com.donovanuy.mixmix.services;

public interface SecurityService{
    String findLoggedInUsername();

    void autologin(String username, String password);
}