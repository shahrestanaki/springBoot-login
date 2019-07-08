package com.model.entity;


import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "User")
@Table(name = "users")
@DynamicUpdate
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "{user.name.null}")
    @Size(min = 2, max = 50, message = "{user.name.size}")
    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @NotEmpty(message = "{user.famili.null}")
    @Size(min = 2, max = 50, message = "{user.famili.size}")
    @Column(name = "famili", length = 50, nullable = false)
    private String famili;

    @NotEmpty(message = "{user.username.null}")
    @Size(min = 2, max = 50, message = "{user.username.size}")
    @Column(name = "username", length = 50, nullable = false)
    private String username;

    @NotEmpty(message = "{user.password.null}")
    @Size(min = 2, max = 255, message = "{user.password.size}")
    @Column(name = "password", length = 255, nullable = false)
    private String password;


    @NotNull(message = "{user.status.null}")
    @Max(value = 4, message = "{user.status.Maxsize}")
    @Min(value = 1, message = "{user.status.Minsize}")
    @Column(name = "status", precision = 1, nullable = false)
    private int status;

    @NotNull(message = "{user.rules.null}")
    @Max(value = 4, message = "{user.rules.Maxsize}")
    @Min(value = 1, message = "{user.rules.Minsize}")
    @Column(name = "rules", precision = 1, nullable = false)
    private int rules;

    //@NotNull(message = "{user.createdate.null}")
    //@ValidDate
    @Column(name = "createdate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdate;

    @Column(name = "changedate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date changedate;

    @Column(name = "edituser")
    private Long edituser;

    @Column(name = "lockdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lockdate;

    @Column(name = "avatar", length = 255)
    private String avatar;

    public User() {
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> authorities = new HashSet<>();


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamili() {
        return famili;
    }

    public void setFamili(String famili) {
        this.famili = famili;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getRules() {
        return rules;
    }

    public void setRules(int rules) {
        this.rules = rules;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public Date getChangedate() {
        return changedate;
    }

    public void setChangedate(Date changedate) {
        this.changedate = changedate;
    }

    public Long getEdituser() {
        return edituser;
    }

    public void setEdituser(Long edituser) {
        this.edituser = edituser;
    }

    public Date getLockdate() {
        return lockdate;
    }

    public void setLockdate(Date lockdate) {
        this.lockdate = lockdate;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Set<Role> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<Role> authorities) {
        this.authorities = authorities;
    }
}
