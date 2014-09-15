package com.lively.domain;

import javax.persistence.MappedSuperclass;

/**
 * Created by franCiS on Sep 14, 2014.
 */
@MappedSuperclass
public abstract class AbstractEntity {

    private int version;
    private boolean archived;
    private boolean active;
}
