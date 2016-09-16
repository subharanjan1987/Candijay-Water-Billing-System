package com.domain;
// Generated Apr 16, 2015 12:48:29 PM by Hibernate Tools 4.3.1


import com.domain.enums.UserStatus;
import com.domain.enums.UserType;

import java.util.Collection;
import java.util.Set;
import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

import javax.validation.constraints.NotNull;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * User generated by hbm2java
 */
@Entity
@Table(name="user")
public class User extends AuditableEntity implements java.io.Serializable, UserDetails {

    @Id @GeneratedValue(strategy=IDENTITY)
    @Column(name="id", unique=true, nullable=false)
    private Long id;
    @Column(name="full_name", nullable=false, length=45)
    private String fullName;
    @Column(name="username", nullable=false, length=16)
    private String username;
    @Column(name="password", nullable=false, length=100)
    private String password;
    @Column(name="status", nullable=false)
    @Enumerated(EnumType.STRING)
    private UserStatus status = UserStatus.ACTIVE;
    @Column(name="type", nullable=false)
    @Enumerated(EnumType.STRING)
    private UserType type;
    @NotNull(message="Please select at least one privilege")
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="usersandroles",
                joinColumns=@JoinColumn(name="user_id"),
                inverseJoinColumns=@JoinColumn(name="role_id"))
    private Set<Role> roles;
    public User() {
    }

    public User(long id, String fullName, String username, String password, UserStatus status, UserType type) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.status = status;
        this.type = type;
        this.fullName = fullName;
    }
    
    public Long getId() {
        return this.id;
    }
    
    public void setId(long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    
    @Override
    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    @Override
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }

    public UserStatus getStatus() {
        return this.status;
    }
    
    public void setStatus(UserStatus status) {
        this.status = status;
    }

    public Set<Role> getRoles() {
        return roles;
    }
    
    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public void addRoles(Role role){
        this.roles.add(role);
    }
    
    public UserType getType() {
        return type;
    }

    public void setType(UserType type) {
        this.type = type;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.roles;
    }

    @Override
    public boolean isAccountNonExpired() {
        return this.status.equals(UserStatus.ACTIVE);
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.status.equals(UserStatus.ACTIVE);
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return this.status.equals(UserStatus.ACTIVE);
    }

    @Override
    public boolean isEnabled() {
        return this.status.equals(UserStatus.ACTIVE);
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
        final User other = (User) obj;
        return new EqualsBuilder().
                        append(this.id, other.id).
                        isEquals();
    }
  
}