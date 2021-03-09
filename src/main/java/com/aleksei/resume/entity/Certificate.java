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
@Table(name = "certificate")
public class Certificate extends AbstractEntity<Long> implements ProfileEntity{

    private static final long serialVersionUID = -3367735808948576258L;

    @Id
    @SequenceGenerator(name = "certificate_id_generator", sequenceName = "certificate_seq", allocationSize = 1)
    @Column(unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "certificate_id_generator")
    private Long id;

    @EqualsAndHashCode.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_profile", nullable = false)
    @JsonIgnore
    private Profile profile;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(name = "large_url", nullable = false)
    private String largeUrl;

    @Column(name = "small_url", nullable = false)
    private String smallUrl;
}
