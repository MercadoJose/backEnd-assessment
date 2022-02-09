package com.assessment.upgradeassessment.controllers;

import java.util.ArrayList;
import java.util.Optional;

import com.assessment.upgradeassessment.models.UserModel;
import com.assessment.upgradeassessment.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public ArrayList<UserModel> obtainUsers() {
        return userService.obtainUser();
    }

    @PostMapping()
    public UserModel saveUsers(@RequestBody UserModel user) {
        return this.userService.saveUser(user);
    }

    @PutMapping(path = "/{id}")
    public UserModel putUser(@RequestBody UserModel userModel,
            @PathVariable("id") Long idUser) {
        return this.userService.putUser(userModel, idUser);
    }

    @GetMapping(path = "/{id}")
    public Optional<UserModel> obtainUserById(@PathVariable("id") Long idUser) {
        return this.userService.obtainByIdUser(idUser);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteById(@PathVariable("id") Long idUser) {

        boolean response = this.userService.deleteUser(idUser);

        if (response) {
            return "The profile with id: " + idUser + ", has been deleted.";
        } else {
            return "There was an error trying to delete a profile with id: " + idUser;
        }
    }
}
