package com.aleksei.resume.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@Table(name = "course")
public class Course extends AbstractFinishDateEntity<Long> implements ProfileEntity{

    private static final long serialVersionUID = -4359077513123719825L;

    @Id
    @SequenceGenerator(name = "course_id_generator", sequenceName = "course_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_id_generator")
    @Column(unique = true, nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_profile", nullable = false)
    @JsonIgnore
    @EqualsAndHashCode.Exclude
    private Profile profile;

    @Column(length = 60)
    private String name;

    @Column(length = 60)
    private String school;
}
