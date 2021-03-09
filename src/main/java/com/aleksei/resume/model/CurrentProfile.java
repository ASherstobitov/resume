package com.aleksei.resume.model;

import com.aleksei.resume.Contacts;
import com.aleksei.resume.entity.Profile;
import lombok.Getter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collections;


@Getter
public class CurrentProfile extends User {

    private static final long serialVersionUID = -8502478074965715556L;

    private final Long id;
    private final String fullName;


    public CurrentProfile(Profile profile) {
        super(profile.getUid(), profile.getPassword(), true, true, true, true, Collections.singleton(new SimpleGrantedAuthority(Contacts.USER)));
        this.id = profile.getId();
        this.fullName = profile.getFullName();
    }


}
