package com.aleksei.resume.repository.search;

import com.aleksei.resume.entity.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ProfileSearchRepository extends ElasticsearchRepository<Profile, Long> {


    Page<Profile> findByObjectiveLikeOrPracticesOrPositionLike(
            String objective, String summary, String practicCompany, String practicPosition, Pageable pageable);

}
