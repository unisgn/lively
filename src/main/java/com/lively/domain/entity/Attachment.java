package com.lively.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by franCiS on Sep 22, 2014.
 */
@Entity
@Table
public class Attachment extends AbstractEnhancedAuditable<Long> {
    @Column(nullable = false)
    private String name;
    @Column(unique = true)
    private String path;
    @Column(nullable = false)
    private String mime;
    @Column(nullable = false)
    private int size = 0;

    private boolean deleted = false;


    public Attachment() { }
}
