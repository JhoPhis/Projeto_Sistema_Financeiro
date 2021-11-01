package com.sistema.financeiro.sisfin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

import com.sistema.financeiro.sisfin.Status;
import com.sistema.financeiro.sisfin.model.Users;
import com.sistema.financeiro.sisfin.repository.UsersRepository;

import java.util.List;
@RestController
public class UsersController {
    @Autowired
    UsersRepository usersRepository;
    @PostMapping("/users/register")
    public Status registerUser(@Valid @RequestBody Users newUser) {
        List<Users> users = usersRepository.findAll();
        System.out.println("New user: " + newUser.toString());
        for (Users user : users) {
            System.out.println("Registered user: " + newUser.toString());
            if (user.equals(newUser)) {
                System.out.println("User Already exists!");
                return Status.USER_ALREADY_EXISTS;
            }
        }
        usersRepository.save(newUser);
        return Status.SUCCESS;
    }
    @PostMapping("/users/login")
    public Status loginUser(@Valid @RequestBody Users user) {
        List<Users> users = usersRepository.findAll();
        for (Users other : users) {
            if (other.equals(user)) {
                user.setLoggedIn(true);
                usersRepository.save(user);
                return Status.SUCCESS;
            }
        }
        return Status.FAILURE;
    }
    @PostMapping("/users/logout")
    public Status logUserOut(@Valid @RequestBody Users user) {
        List<Users> users = usersRepository.findAll();
        for (Users other : users) {
            if (other.equals(user)) {
                user.setLoggedIn(false);
                usersRepository.save(user);
                return Status.SUCCESS;
            }
        }
        return Status.FAILURE;
    }
    @DeleteMapping("/users/all")
    public Status deleteUsers() {
        usersRepository.deleteAll();
        return Status.SUCCESS;
    }
}