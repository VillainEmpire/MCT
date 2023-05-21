package com.geekster.foodDeliverySystem.controller;

import com.geekster.foodDeliverySystem.dto.SignInInput;
import com.geekster.foodDeliverySystem.dto.SignInOutput;
import com.geekster.foodDeliverySystem.dto.SignUpOutput;
import com.geekster.foodDeliverySystem.model.User;
import com.geekster.foodDeliverySystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public SignUpOutput signUp(@Valid @RequestBody User signUpInput){
        return userService.signUp(signUpInput);
    }

    @PostMapping("/signin")
    public SignInOutput signIn(@Valid @RequestBody SignInInput signInInput){
        return userService.signIn(signInInput);
    }
}

