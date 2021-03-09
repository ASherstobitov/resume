package com.aleksei.resume.service.impl;

import com.aleksei.resume.entity.Profile;
import com.aleksei.resume.entity.Skill;
import com.aleksei.resume.exception.CantCompleteClienRequestException;
import com.aleksei.resume.form.SignUpForm.SignUpForm;
import com.aleksei.resume.repository.search.ProfileSearchRepository;
import com.aleksei.resume.repository.storage.ProfileRepository;
import com.aleksei.resume.repository.storage.SkillCategoryRepository;
import com.aleksei.resume.service.EditProfileService;
import com.aleksei.resume.util.DataUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.transaction.support.TransactionSynchronizationAdapter;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import java.util.Collections;
import java.util.List;

public class EditProfileServiceImpl implements EditProfileService {

    private static final Logger LOGGER = LoggerFactory.getLogger(EditProfileServiceImpl.class);

    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private ProfileSearchRepository profileSearchRepository;

    @Autowired
    private SkillCategoryRepository skillCategoryRepository;

    @Value("${generate.uid.suffix.length}")
    private int getGenerateUidSuffixLength;

    @Value("${generate.uid.alphabet}")
    private int generateUidSuffixLength;

    @Value("${generate.uid.max.try.count}")
    private int maxTryCountToGenerateUid;

    @Override
    public Profile createNewProfile(SignUpForm signUpForm) {

        Profile profile = new Profile();
        profile.setUid(generateProfileUid(signUpForm));
        profile.setFirstName(DataUtil.capitalizeName(signUpForm.getFirstName()));
        profile.setFirstName(DataUtil.capitalizeName(signUpForm.getLastName()));
        profile.setPassword(signUpForm.getPassword());
        profile.setCompleted(false);
        profileRepository.save(profile);
        registerCreateIndexProfileIfTrancationSuccess(profile);
        return profile;
    }

    private void registerCreateIndexProfileIfTrancationSuccess(final Profile profile) {
        TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronizationAdapter() {
            @Override
            public void afterCommit() {
                LOGGER.info("New profile created: {}", profile.getUid());
                profile.setCertificates(Collections.EMPTY_LIST);
                profile.setPractices(Collections.EMPTY_LIST);
                profile.setLanguages(Collections.EMPTY_LIST);
                profile.setSkills(Collections.EMPTY_LIST);
                profile.setCourses(Collections.EMPTY_LIST);
                profileSearchRepository.save(profile);
                LOGGER.info("New profile index created: {}", profile.getUid());
            }
        });
    }

    private String generateProfileUid(SignUpForm signUpForm) {
        return null;
    }

    @Override
    public List<Skill> skills(long idProfile) {
        return null;
    }

    @Override
    public void updateSkills(long idProfile, List<Skill> skills) {

    }
}
