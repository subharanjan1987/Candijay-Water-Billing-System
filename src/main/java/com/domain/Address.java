package com.domain;
// Generated May 2, 2015 10:45:47 PM by Hibernate Tools 4.3.1


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Set;
import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

import javax.validation.constraints.NotNull;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Address generated by hbm2java
 */
@Entity
@Table(name="address")
public class Address  implements java.io.Serializable {


    @Id @GeneratedValue(strategy=IDENTITY)
    @Column(name="id", unique=true, nullable=false)
    private Long id; 
    @OneToMany(fetch=FetchType.LAZY, mappedBy="address")
    private Set<Account> accounts;
    @NotEmpty(message = "This field is required") @NotBlank(message = "This field is required")
    @Column(name="brgy", nullable=false, length=45)
    private String brgy;
    @Column(name="location_code", nullable=false)
    private Integer locationCode;
    @Column(name="account_prefix", length=2)
    private String accountPrefix;
    @Column(name="accounts_count", nullable=false)
    private Integer accountsCount;
    @Column(name="due_day", nullable=false)
    private Integer dueDay;
    
    public Address() {
    }

    public Address(Set<Account> accounts, String brgy, Integer locationCode, String accountPrefix, Integer accountsCount, Integer dueDay) {
        this.accounts = accounts;
        this.brgy = brgy;
        this.locationCode = locationCode;
        this.accountPrefix = accountPrefix;
        this.accountsCount = accountsCount;
        this.dueDay = dueDay;
    }

      
    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    @JsonBackReference
    public Set getAccounts() {
        return this.accounts;
    }
    
    @JsonProperty
    public void setAcounts(Set<Account> accounts){
        this.accounts = accounts;
    }
    
    public void addAccount(Account account) {
        this.accounts.add(account);
    }

    public String getBrgy() {
        return this.brgy;
    }
    
    public void setBrgy(String brgy) {
        this.brgy = brgy;
    }

    public Integer getLocationCode() {
        return this.locationCode;
    }
    
    public void setLocationCode(Integer locationCode) {
        this.locationCode = locationCode;
    }

    public Integer getDueDay() {
        return dueDay;
    }

    public void setDueDay(Integer dueDay) {
        this.dueDay = dueDay;
    }

    public Integer getAccountsCount() {
        return accountsCount;
    }

    public void setAccountsCount(Integer accountsCount) {
        this.accountsCount = accountsCount;
    }

    public String getAccountPrefix() {
        return accountPrefix;
    }

    public void setAccountPrefix(String accountPrefix) {
        this.accountPrefix = accountPrefix;
    }

    @Override
    public String toString(){
        return brgy+", Zone "+locationCode;
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
        final Address other = (Address) obj;
        return new EqualsBuilder().
                append(this.id, other.id).
                isEquals();
    }
}
