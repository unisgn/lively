package com.lively.service;

import java.io.Serializable;

/**
 * Created by franCiS on Oct 06, 2014.
 */
public interface EntityMgr<E, PK extends Serializable> {
    public E get(PK id);
    public E save(E entity);
}
