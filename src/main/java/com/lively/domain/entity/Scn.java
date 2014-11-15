package com.lively.domain.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by franCiS on Sep 30, 2014.
 * Social Contact Number
 */
@Entity
@Table
public class Scn extends AbstractPersistable<Integer> {
    private String type;
    private String number;

}
