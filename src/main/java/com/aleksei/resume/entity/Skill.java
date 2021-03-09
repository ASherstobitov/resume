package com.aleksei.resume.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@Table(name = "skill")
public class Skill extends AbstractEntity<Long> implements ProfileEntity{

    private static final long serialVersionUID = -3585613219172037369L;

    @Id
    @SequenceGenerator(name = "skill_id_generator", sequenceName = "skill_seq", allocationSize = 1)
    @Column(unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "skill_id_generator")
    private Long id;

    @EqualsAndHashCode.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false, name = "id_profile")
    @JsonIgnore
    private Profile profile;

    @Column(name = "category", length = 50)
    private String category;

    @Column(length = 2147483647, nullable = false)
    private String value;
}
