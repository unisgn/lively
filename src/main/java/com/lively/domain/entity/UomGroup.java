package com.lively.domain.entity;

import javax.persistence.*;

/**
 * Created by franCiS on Oct 01, 2014.
 */
@Entity
@Table
public class UomGroup extends AbstractEnhancedPersistable<Integer> {
    private String name;
}
