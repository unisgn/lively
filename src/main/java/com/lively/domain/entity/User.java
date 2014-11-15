package com.lively.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by franCiS on Sep 14, 2014.
 */
@Entity
@Table(name = "t_user")
public class User extends AbstractEnhancedPersistable<Integer> {

    @Column(nullable = false, unique = true)
    private String username;
    private String password;

    public User() { }

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
}
