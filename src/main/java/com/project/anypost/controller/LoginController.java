package com.project.anypost.controller;

import com.project.anypost.domain.User;
import com.project.anypost.excaption.UserAlreadyExistException;
import com.project.anypost.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class LoginController {
    @Autowired
    LoginService loginService;

    @PostMapping("")
    public void createUser(@RequestBody User user) throws UserAlreadyExistException {
        try {
            loginService.createUserService(user);
        } catch (UserAlreadyExistException e) {
            throw new UserAlreadyExistException("User already exist");
        }
    }
}
