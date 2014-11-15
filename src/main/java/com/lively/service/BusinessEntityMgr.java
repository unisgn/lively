package com.lively.service;

import java.io.Serializable;

/**
 * Created by franCiS on Oct 06, 2014.
 */
public interface BusinessEntityMgr<E, PK extends Serializable> extends EntityMgr<E, PK> {
    public E getByNumber(String number);
    public E getByCode(String code);
    public E getByName(String name);

    public boolean existsByNumber(String number);
    public boolean existsByCode(String code);
    public boolean existsByName(String name);
}
