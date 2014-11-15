package com.lively.domain.entity;

import javax.persistence.*;

/**
 * Created by franCiS on Sep 14, 2014.
 */
@Entity
@Table
public class Employee extends BusinessEntity {

    @ManyToOne
    private Department dept;

    public Employee() { }
}
