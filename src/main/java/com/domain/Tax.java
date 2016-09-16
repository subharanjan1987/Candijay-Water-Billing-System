package com.domain;
// Generated Apr 16, 2015 12:48:29 PM by Hibernate Tools 4.3.1


import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Tax generated by hbm2java
 */
@Entity
@Table(name="tax")
public class Tax  implements java.io.Serializable {

    @Id @GeneratedValue(strategy=IDENTITY)
    @Column(name="id", unique=true, nullable=false)
    private Integer id;
    @Column(name="code", nullable=false, length=45)
    private String code;
    @Column(name="description", nullable=false)
    private String description;
    @Column(name="value", nullable=false, precision=9)
    private BigDecimal value;

    public Tax() {
    }
	
    public Tax(String code, String description, BigDecimal value) {
        this.code = code;
        this.description = description;
        this.value = value;
    }
    
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getCode() {
        return this.code;
    }
    
    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getValue() {
        return this.value;
    }
    
    public void setValue(BigDecimal value) {
        this.value = value;
    }
    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 31). // two randomly chosen prime numbers
                // if deriving: appendSuper(super.hashCode()).
                        append(this.id).
                        toHashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Tax other = (Tax) obj;
        return new EqualsBuilder().
                append(this.id, other.id).
                isEquals();
    }

}