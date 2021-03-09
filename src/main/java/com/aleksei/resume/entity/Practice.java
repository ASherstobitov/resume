package com.aleksei.resume.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.joda.time.DateTime;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@Table(name = "practic")
public class Practice extends AbstractFinishDateEntity<Long> implements Serializable, ProfileEntity {

    private static final long serialVersionUID = 2242920519175663483L;

    @Id
    @SequenceGenerator(name = "practic_id_generator", sequenceName = "practic_seq", allocationSize = 1)
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "practic_id_generator")
    private Long id;

    @EqualsAndHashCode.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_profile", nullable = false)
    private Profile profile;

    @Column(nullable = false, length = 100)
    private String position;

    @Column(nullable = false, length = 100)
    private String company;

    @Column(name = "begin_date", nullable = false)
    private Date beginDate;

    @Transient
    private Integer beginDateMonth;

    @Transient
    private Integer beginDateYear;

    @Column(length = 2147483647,nullable = false)
    private String responsibility;

    @Column
    private String demo;

    @Column
    private String src;

    @Transient
    public Integer getBeginDateMonth() {
        if (beginDate != null) {
            return new DateTime(beginDate).getDayOfMonth();
        } else {
            return null;
        }
    }

    @Transient
    public Integer getBeginDateYear() {
        if (beginDate != null) {
            return new DateTime(beginDate).getYear();
        } else {
            return null;
        }
    }

    public void setBeginDateMonth(Integer beginDateMonth) {
        this.beginDateMonth = beginDateMonth;
        setupBeginDate();
    }

    public void setBeginDateYear(Integer beginDateYear) {
        this.beginDateYear = beginDateYear;
        setupBeginDate();
    }

    protected void setupBeginDate(){
        if (beginDateYear != null && beginDateMonth != null) {
            setBeginDate(new Date(new DateTime(beginDateYear, beginDateMonth, 1, 0, 0 ).getMillis()));
        } else {
            setBeginDate(null);
        }
    }
}
