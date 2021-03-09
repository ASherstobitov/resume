package com.aleksei.resume.repository.storage;

import com.aleksei.resume.entity.ProfileRestore;
import org.springframework.data.repository.CrudRepository;

public interface ProfileRestoreRepository extends CrudRepository<ProfileRestore, Long> {

    ProfileRestore findByToken(String token);
}
