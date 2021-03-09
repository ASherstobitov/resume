package com.aleksei.resume.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import org.joda.time.LocalDate;
import org.joda.time.Years;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "profile")
@Document(indexName = "profile")
public class Profile extends AbstractEntity<Long> {

    private static final long serialVersionUID = -1641331348179513486L;

    @Id
    @SequenceGenerator(name = "profile_id_generator", sequenceName = "profile_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "profile_id_generator")
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "birth_day")
    private Date birthDay;

    @Column
    private String city;

    @Column
    private String country;

    @Column(name = "first_name", nullable = false, length = 50)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 50)
    private String lastName;


    @Column(length = 2147483647)
    private String objective;

    @Column(name = "large_photo", length = 255)
    private String largePhoto;

    @Column(name = "small_photo", length = 255)
    private String smallPhoto;

    @Column(length = 20)
    private String phone;

    @Column(length = 100)
    @JsonIgnore
    private String email;

    @Column(length = 2147483647)
    private String summary;

    @Column(length = 2147483647)
    private String info;

    @Column(name = "uid", length = 100)
    private String uid;

    @Column(nullable = false, length = 100)
    @JsonIgnore
    private String password;

    @Column(nullable = false)
    @JsonIgnore
    private boolean completed;

    @Column(nullable = false)
    @JsonIgnore
    private Timestamp created;

    @Embedded
    private Contact contact;

    @OneToMany(mappedBy = "profile", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private List<Certificate> certificates;

    @OneToMany(mappedBy = "profile", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private List<Course> courses;

    @OneToMany(mappedBy = "profile", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @OrderBy("finishYear DESC, beginYear DESC, id DESC")
    @JsonIgnore
    private List<Education> educations;

    @OneToMany(mappedBy = "profile", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @OrderBy("name ASC")
    private List<Hobby> hobbies;

    @OneToMany(mappedBy = "profile", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JsonIgnore
    private List<Language> languages;

    @OneToMany(mappedBy = "profile", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @OrderBy("beginDate DESC")
    private List<Practice> practices;

    @OneToMany(mappedBy = "profile", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @OrderBy("id ASC")
    private List<Skill> skills;

    @Transient
    public String getFullName() {
        return firstName + " " + lastName;
    }

    @Transient
    public int getAge() {
        LocalDate birthdate = new LocalDate(birthDay);
        LocalDate now = new LocalDate();
        Years age = Years.yearsBetween(birthdate, now);
        return age.getYears();
    }

    @Transient
    public String getProfilePhoto(){
        if (largePhoto != null) {
            return largePhoto;
        } else {
            return "static/img/profile-placeholder.png";
        }
    }

    public String updateProfilePhotos(String largePhoto, String smallPhoto) {
        String oldLargeImage = this.largePhoto;
        setLargePhoto(largePhoto);
        setSmallPhoto(smallPhoto);
        return oldLargeImage;
    }
    // https://hibernate.atlassian.net/browse/HHH-7610
    public Contact getContact() {
        if(contact == null) {
            contact = new Contact();
        }
        return contact;
    }

    public void updateListSetProfile(List<? extends ProfileEntity> list) {
        if(list != null) {
            for (ProfileEntity profileEntity : list) {
                profileEntity.setProfile(this);
            }
        }
    }

}
