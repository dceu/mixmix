package com.donovanuy.mixmix.controllers;

import java.util.Map;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import org.springframework.ui.Model;

import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.validation.BindingResult;
import javax.validation.Valid;

import com.donovanuy.mixmix.repository.UserRepository;
import com.donovanuy.mixmix.entities.User;
import com.donovanuy.mixmix.services.UserService;
import com.donovanuy.mixmix.services.SecurityService;

import com.donovanuy.mixmix.validator.*;


@Controller
public class UserController {
@Autowired
private UserService userService;

@Autowired
private SecurityService securityService;

@Autowired
private UserValidator userValidator;

@RequestMapping(value = "/registration", method = RequestMethod.GET)
public String registration(Model model) {
    model.addAttribute("userForm", new User());

    return "registration";
}

@RequestMapping(value = "/registration", method = RequestMethod.POST)
public String registration(@ModelAttribute("userForm") User userForm, 
 BindingResult bindingResult, Model model) {
    userValidator.validate(userForm, bindingResult);

    if (bindingResult.hasErrors()) {
        return "registration";
    }

    userService.save(userForm);

    securityService.autologin(userForm.getUsername(), userForm.getPasswordConfirm());

    return "redirect:/recipes";
}

@RequestMapping(value = "/login", method = RequestMethod.GET)
public String login(Model model, String error, String logout) {
    if (error != null)
        model.addAttribute("error", "Your username and password is invalid.");

    if (logout != null)
        model.addAttribute("message", "You have been logged out successfully.");

    return "login";
}

@RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
public String welcome(Model model) {
    return "index";
}
}