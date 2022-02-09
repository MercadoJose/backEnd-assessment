package com.assessment.upgradeassessment.services;

import java.util.ArrayList;
import java.util.Optional;

import com.assessment.upgradeassessment.models.UserModel;
import com.assessment.upgradeassessment.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public ArrayList<UserModel> obtainUser() {
        return (ArrayList<UserModel>) userRepository.findAll();
    }

    public UserModel saveUser(UserModel user) {
        return userRepository.save(user);
    }

    public UserModel putUser(UserModel userModel, Long idUser) {
        return userRepository.findById(idUser)
                .map(user -> {
                    user.setUserName(userModel.getUserName());
                    user.setPassword(userModel.getPassword());
                    user.setIdProfile(userModel.getIdProfile());
                    user.setIdEmployee(userModel.getIdEmployee());
                    user.setStatus(userModel.getStatus());
                    user.setCreatedDate(userModel.getCreatedDate());
                    user.setUpdateDate(userModel.getUpdateDate());
                    user.setLogin(userModel.getLogin());
                    return userRepository.save(user);
                })
                .orElseGet(() -> {
                    userModel.setIdUser(idUser);
                    return userRepository.save(userModel);
                });
    }

    public Optional<UserModel> obtainByIdUser(Long idUser) {
        return userRepository.findById(idUser);
    }

    public boolean deleteUser(Long idUser) {
        try {
            userRepository.deleteById(idUser);
            return true;
        } catch (Exception err) {
            return false;
        }
    }
}
