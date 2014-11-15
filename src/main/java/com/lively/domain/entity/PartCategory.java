package com.lively.domain.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by franCiS on Sep 23, 2014.
 */
@Entity
@Table
public class PartCategory extends BusinessEntity implements TreeEntity<PartCategory> {

    @ManyToOne
    private PartCategory parentNode;

    @OneToMany(mappedBy = "parentNode")
    private Set<PartCategory> childNodes = new HashSet<PartCategory>();


    public PartCategory getParentNode() { return parentNode; }
    public Set<PartCategory> getChildNodes() { return childNodes; }
}
