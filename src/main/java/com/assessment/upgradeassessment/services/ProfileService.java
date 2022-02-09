package com.assessment.upgradeassessment.services;

import java.util.ArrayList;
import java.util.Optional;

import com.assessment.upgradeassessment.models.ProfileModel;
import com.assessment.upgradeassessment.repositories.ProfileRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {

    @Autowired
    ProfileRepository profileRepository;

    public ArrayList<ProfileModel> obtainProfile() {
        return (ArrayList<ProfileModel>) profileRepository.findAll();
    }

    public ProfileModel saveProfile(ProfileModel profile) {
        return profileRepository.save(profile);
    }

    public ProfileModel putProfile(ProfileModel profileModel, Long idProfile) {
        return profileRepository.findById(idProfile)
                .map(profile -> {
                    profile.setProfile(profileModel.getProfile());
                    return profileRepository.save(profile);
                })
                .orElseGet(() -> {
                    profileModel.setIdProfile(idProfile);
                    return profileRepository.save(profileModel);
                });
    }

    public Optional<ProfileModel> obtainByIdProfile(Long idProfile) {
        return profileRepository.findById(idProfile);
    }

    public boolean deleteProfile(Long idProfile) {
        try {
            profileRepository.deleteById(idProfile);
            return true;
        } catch (Exception err) {
            return false;
        }
    }
}
