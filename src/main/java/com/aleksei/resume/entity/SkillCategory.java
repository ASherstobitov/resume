package com.aleksei.resume.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Table(name = "skill_category")
public class SkillCategory extends AbstractEntity<Long> {
    private static final long serialVersionUID = -8959739023562086833L;
    @Id
    @Column(name = "id")
    private Long id;

    @Column(nullable = false, length = 50)
    private String category;
}
