package com.lively.domain.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Created by franCiS on Sep 23, 2014.
 */
@Entity
@Table
public class Uom extends AbstractEnhancedPersistable<Integer> {
    private String name;

    @ManyToOne
    private UomGroup uomGroup;
    private int ratio = 1;

    private boolean isBase = true;

    public Uom() {}
}
