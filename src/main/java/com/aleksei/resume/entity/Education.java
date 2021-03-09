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
@Table(name = "education")
public class Education extends AbstractEntity<Long> implements ProfileEntity{

    private static final long serialVersionUID = -6905326835672103555L;

    @Id
    @SequenceGenerator(name = "education_id_generator", sequenceName = "education_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "education_id_generator")
    @Column(unique = true, nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_profile", nullable = false)
    @EqualsAndHashCode.Exclude
    private Profile profile;

    @Column(nullable = false, length = 100)
    private String summary;

    @Column(name = "begin_year", nullable = false)
    private Integer beginYear;

    @Column(name = "finish_year")
    private Integer finishYear;

    @Column(length = 2147483647, nullable = false)
    private String university;

    @Column(nullable = false)
    private String faculty;

}
