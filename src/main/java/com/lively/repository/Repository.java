package com.lively.repository;

import com.lively.domain.entity.AbstractPersistable;
import com.lively.domain.entity.Persistable;

import java.io.Serializable;
import java.util.List;

/**
 * Created by franCiS on Oct 04, 2014.
 */
public interface Repository<E extends Persistable, PK extends Serializable> {
    public E get(PK id);
    public List<E> findAll();
    public E save(E entity);
}
