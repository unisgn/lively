package com.lively.domain.entity;

import java.util.Set;

/**
 * Created by franCiS on Sep 27, 2014.
 */
public interface TreeEntity<E> {
    public E getParentNode();
    public Set<E> getChildNodes();
}
