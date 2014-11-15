package com.lively.domain.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by franCiS on Oct 01, 2014.
 */
@Entity
@Table
public class PartPropertyLabelGroup extends AbstractPersistable<Integer> {
    private String name;

    @ManyToOne
    private PartCategory partCategory;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "group_fk")
    private Set<PartPropertyLabel> labels = new HashSet<PartPropertyLabel>();
}
