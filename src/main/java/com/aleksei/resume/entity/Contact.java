package com.aleksei.resume.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
@Setter
@Getter
@Access(AccessType.FIELD)
public class Contact implements Serializable  {

    private static final long serialVersionUID = -3807618087369030530L;

    @Column(length = 80)
    private String skype;

    @Column
    private String vkontakte;

    @Column
    private String facebook;

    @Column
    private String linkedin;

    @Column
    private String github;

    @Column
    private String stackoverflow;
}
