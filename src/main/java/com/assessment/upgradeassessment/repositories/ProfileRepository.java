package com.assessment.upgradeassessment.repositories;

import java.util.ArrayList;

import com.assessment.upgradeassessment.models.ProfileModel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends CrudRepository<ProfileModel, Long> {

    public abstract ArrayList<ProfileModel> findByIdProfile(Long idProfile);
}
