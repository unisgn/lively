package com.lively.domain.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by franCiS on Oct 01, 2014.
 */
@Entity
@Table
public class PartPropertyLabel extends AbstractPersistable<Integer> {
    private String name;
}
