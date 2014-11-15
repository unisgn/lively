package com.lively.domain.entity;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Created by franCiS on Oct 03, 2014.
 */
@Entity
@Table
public class CustomerManager extends AbstractPersistable<Integer> {
    @OneToOne
    private Employee employee;

    public CustomerManager() { }
}
