package com.lively.domain.entity;

import java.io.Serializable;

/**
 * Created by franCiS on Oct 01, 2014.
 * Copy of org.springframework.data.domain.Persistable
 */
public interface Persistable<ID extends Serializable> extends Serializable {

    /**
     * Returns the id of the entity.
     *
     * @return the id
     */
    ID getId();


    /**
     * Returns if the {@code Persistable} is new or was persisted already.
     *
     * @return if the object is new
     */
    boolean isNew();
}
