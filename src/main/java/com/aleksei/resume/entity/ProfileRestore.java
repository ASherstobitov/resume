package com.aleksei.resume.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@Table(name = "profile_restore")
public class ProfileRestore extends AbstractEntity<Long> implements Serializable {

    private static final long serialVersionUID = 3019591138155229044L;

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id", nullable = false)
    private Profile profile;

    @Column(nullable = false, unique = true, length = 100)
    private String token;
}
