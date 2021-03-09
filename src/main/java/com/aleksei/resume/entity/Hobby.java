package com.aleksei.resume.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@RequiredArgsConstructor
@NoArgsConstructor
@Table(name = "hobby")
public class Hobby extends AbstractEntity<Long> implements Comparable<Hobby>, ProfileEntity {

    private static final long serialVersionUID = -6482912946884558015L;

    @Id
    @EqualsAndHashCode.Exclude
    @SequenceGenerator(name = "hobby_id_generator", sequenceName = "hobby_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hobby_id_generator")
    @Column(unique = true, nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_profile", nullable = false)
    @EqualsAndHashCode.Exclude
    private Profile profile;

    @Column(nullable = false, length = 30)
    @NonNull
    private String name;

    @Transient
    @NonNull
    @EqualsAndHashCode.Exclude
    private boolean selected;

    @Override
    public int compareTo(Hobby o) {
        if (o == null || getName() == null) {
            return 1;
        } else {
        return getName().compareTo(o.getName());
        }
    }

    @Override
    public String toString() {
        return String.format("Hobby [name=%s]", name);
    }
}
