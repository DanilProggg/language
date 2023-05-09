package com.project.anypost.services;

import com.project.anypost.domain.User;
import com.project.anypost.excaption.UserAlreadyExistException;
import com.project.anypost.repos.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Autowired
    UsersRepo usersRepo;

    public void createUserService(User user) throws UserAlreadyExistException {

        if (usersRepo.findByName(user.getName()) != null) {
            throw new UserAlreadyExistException("User already exist");
        } else {
            usersRepo.save(user);
        }
    }
}