package com.lively.domain.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by franCiS on Sep 23, 2014.
 */
@Entity
@Table
public class Bom extends AbstractEnhancedAuditable<Integer> {

    @OneToOne
    private Part part;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "bom_fk")
    private Set<BomItem> items = new HashSet<BomItem>();

    public Bom() {}
}
