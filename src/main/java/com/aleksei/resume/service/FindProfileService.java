package com.aleksei.resume.service;

import com.aleksei.resume.entity.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface FindProfileService {

    Profile findByUid(String uid);

    Page<Profile> findAll(Pageable pageable);

    Iterable<Profile> findAllFroIndexing();

    Page<Profile> findBySearchQuery(String query, Pageable pageable);
}
