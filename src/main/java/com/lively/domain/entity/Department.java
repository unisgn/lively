package com.lively.domain.entity;

import org.joda.time.DateTime;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by franCiS on Sep 14, 2014.
 */

@Entity
@Table
public class Department extends BusinessEntity {
    @OneToOne
    private Employee leader;

    @ManyToOne
    private Department parentNode;

    @OneToMany(mappedBy = "parentNode")
    private Set<Department> childNodes = new HashSet<Department>();

    public Department() {}

}
