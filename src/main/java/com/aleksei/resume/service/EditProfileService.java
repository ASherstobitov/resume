package com.aleksei.resume.service;

import com.aleksei.resume.entity.Profile;
import com.aleksei.resume.entity.Skill;
import com.aleksei.resume.form.SignUpForm.SignUpForm;

import java.util.List;

public interface EditProfileService {

    Profile createNewProfile(SignUpForm signUpForm);

    List<Skill> skills(long idProfile);

    void updateSkills(long idProfile, List<Skill> skills);
}
