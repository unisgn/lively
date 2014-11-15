package com.lively.domain.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by franCiS on Sep 23, 2014.
 */
@Entity
@Table
public class Contact extends AbstractEnhancedPersistable<Integer> {
    private String name;
    private String title;

    private String jobTitle;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinTable(name = "link_contact_scns")
    private List<Scn> scns = new ArrayList<Scn>();

    public Contact() { }
}
