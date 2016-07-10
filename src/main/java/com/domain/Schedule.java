package com.domain;
// Generated May 28, 2015 12:52:54 PM by Hibernate Tools 4.3.1

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.text.DateFormatSymbols;

/**
 * Schedule generated by hbm2java
 */
@Entity
@Table(name="schedule"
    ,catalog="revised_cws_db"
)
public class Schedule  implements java.io.Serializable {

    @Id @GeneratedValue(strategy=IDENTITY)
    @Column(name="id", unique=true, nullable=false)
    private Long id;
    @NotNull
    @Column(name="month", nullable=false, length=2)
    private Integer month;
    @NotNull
    @Column(name="year", nullable=false, length=4)
    private Integer year ;

    public Schedule() {
    }
	
    public Schedule(Integer month, Integer year) {
        this.month = month;
        this.year = year;
    }
     
    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }
    
    public String getMonthSymbol(){
        return new DateFormatSymbols().getMonths()[month.intValue() - 1];
    }
}
