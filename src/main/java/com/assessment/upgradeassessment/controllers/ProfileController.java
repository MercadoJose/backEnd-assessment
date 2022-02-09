package com.assessment.upgradeassessment.controllers;

import java.util.ArrayList;
import java.util.Optional;

import com.assessment.upgradeassessment.models.ProfileModel;
import com.assessment.upgradeassessment.services.ProfileService;

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
@RequestMapping("/profiles")
public class ProfileController {

    @Autowired
    ProfileService profileService;

    @GetMapping
    public ArrayList<ProfileModel> obtainProfiles() {
        return profileService.obtainProfile();
    }

    @PostMapping()
    public ProfileModel saveProfiles(@RequestBody ProfileModel profile) {
        return this.profileService.saveProfile(profile);
    }

    @PutMapping(path = "/{id}")
    public ProfileModel putProfile(@RequestBody ProfileModel profileModel,
            @PathVariable("id") Long idProfile) {
        return this.profileService.putProfile(profileModel, idProfile);
    }

    @GetMapping(path = "/{id}")
    public Optional<ProfileModel> obtainProfileById(@PathVariable("id") Long idProfile) {
        return this.profileService.obtainByIdProfile(idProfile);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteById(@PathVariable("id") Long idProfile) {

        boolean response = this.profileService.deleteProfile(idProfile);

        if (response) {
            return "The profile with id: " + idProfile + ", has been deleted.";
        } else {
            return "There was an error trying to delete a profile with id: " + idProfile;
        }
    }
}
