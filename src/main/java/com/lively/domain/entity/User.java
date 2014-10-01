package com.lively.domain.entity;

import javax.persistence.Entity;

/**
 * Created by franCiS on Sep 14, 2014.
 */
@Entity
public class User extends AbstractEnhancedPersistable {

    private String username;
    private String password;
}
