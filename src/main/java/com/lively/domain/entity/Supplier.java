package com.lively.domain.entity;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Created by franCiS on Sep 14, 2014.
 */
@Entity
@Table
public class Supplier extends BusinessEntity {
    @OneToOne
    private BusinessPartner partner;

    public Supplier() { }
}
