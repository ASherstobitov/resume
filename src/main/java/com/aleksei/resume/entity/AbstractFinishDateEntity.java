package com.aleksei.resume.entity;

import lombok.Getter;
import lombok.Setter;
import org.joda.time.DateTime;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;
import java.util.Date;

@Setter
@Getter
@MappedSuperclass
public abstract class AbstractFinishDateEntity<T> extends AbstractEntity<T>{

    private static final long serialVersionUID = 6658363136746930435L;

    @Column(name = "finish_date")
    private Date finishDate;

    @Transient
    private Integer finishDateMonth;

    @Transient
    private Integer finishDateYear;

    @Transient
    public boolean isFinishDate() {
       return finishDate != null;
    }

    @Transient
    public Integer getFinishDateMonth() {
        if (finishDate != null) {
            return new DateTime(finishDate).getDayOfMonth();
        } else {
            return null;
        }
    }

    @Transient
    public Integer getFinishDateYear() {
        if (finishDate != null) {
            return new DateTime(finishDate).getYear();
        } else {
            return null;
        }
    }

    public void setFinishDateMonth(Integer finishDateMonth) {
        this.finishDateMonth = finishDateMonth;
        setupFinishDate();
    }

    public void setFinishDateYear(Integer finishDateYear) {
        this.finishDateYear = finishDateYear;
        setupFinishDate();
    }

    protected void setupFinishDate(){
        if (finishDateYear != null && finishDateMonth != null) {
            setFinishDate(new Date(new DateTime(finishDateYear, finishDateMonth, 1, 0, 0 ).getMillis()));
        } else {
            setFinishDate(null);
        }
    }
}
