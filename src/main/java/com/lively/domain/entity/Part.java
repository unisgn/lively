package com.lively.domain.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by franCiS on Sep 14, 2014.
 */

@Entity
@Table
public class Part extends BusinessEntity {

    @ManyToMany
    @JoinTable(name = "link_part_labels")
    private Set<PartPropertyLabel> labels = new HashSet<PartPropertyLabel>();

    private boolean hasBom = false;

    @ManyToOne
    @JoinTable(name = "link_part_uom")
    private Uom uom;
    private BigDecimal unitValue;

    private int inStock;
    private int inNeed;
    private int inManufacture;


    public Part() {}

}
