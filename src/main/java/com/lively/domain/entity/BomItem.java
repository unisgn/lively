package com.lively.domain.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Created by franCiS on Oct 04, 2014.
 */
@Entity
@Table
public class BomItem extends AbstractPersistable<Integer>{

    private int lineNo;
    @ManyToOne
    private Part part;
    private int qty;
    private String brief;

    public BomItem() { }
}
