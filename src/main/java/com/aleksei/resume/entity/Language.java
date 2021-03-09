package com.aleksei.resume.entity;

import com.aleksei.resume.model.LanguageLevel;
import com.aleksei.resume.model.LanguageType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@Table(name = "language")
public class Language extends AbstractEntity<Long> implements ProfileEntity {

    private static final long serialVersionUID = 1155795643934697507L;

    @Id
    @SequenceGenerator(name = "language_id_generator", sequenceName = "language_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "language_id_generator")
    @Column(unique = true, nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_profile", nullable = false)
    @EqualsAndHashCode.Exclude
    @JsonIgnore
    private Profile profile;

    @Column(nullable = false, length = 30)
    private String name;

    @Column(nullable = false)
    @Convert(converter = LanguageLevel.PersistJPAConverter.class)
    private LanguageLevel level;

    @Column(nullable = false)
    @Convert(converter = LanguageType.PersistJPAConverter.class)
    private LanguageType type;

    @Override
    public String toString() {
        return String.format("Language [id=%s, level+=%s, name=%s, type=%s]", id, level, name, type);
    }
}
