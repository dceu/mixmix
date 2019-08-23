package com.donovanuy.mixmix.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.validation.BindingResult;
import javax.validation.Valid;

import com.donovanuy.mixmix.repository.UserRepository;
import com.donovanuy.mixmix.entities.User;


@Controller 
@RequestMapping("/users")
public class UserController implements WebMvcConfigurer {
    @Autowired
    private UserRepository userRepository;

       //* Form *//
    @Override
    public void addViewControllers(ViewControllerRegistry registry){
        registry.addViewController("/results").setViewName("results");

    }

    @GetMapping("/new")
    public String showForm(User user) { 
        return "form";
    }

    @PostMapping("/new")
    public String checkPersonInfo(@Valid User user,
         BindingResult bindingResult){
        
        while (bindingResult.hasErrors()) {
            return "form";
        }

        String name = user.getName();
        String email = user.getEmail();
        Integer age = user.getAge();
        addNewUser(name, email, age);
        
        return "results";
    }

        //* End Form *//

    @PostMapping(path="/add") //Map ONLY POST Requests
    public @ResponseBody void addNewUser (@RequestParam String name,
                @RequestParam String email, @RequestParam Integer age) {
                    User n = new User();
                    n.setName(name);
                    n.setAge(age);
                    n.setEmail(email);
                    userRepository.save(n);
                    
                }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/user/{id}")
    public User show(@PathVariable String id){
        int userId = Integer.parseInt(id);
        return userRepository.getOne(userId);
    }
}