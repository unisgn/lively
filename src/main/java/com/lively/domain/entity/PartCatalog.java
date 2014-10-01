package com.lively.domain.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by franCiS on Sep 23, 2014.
 */
public class PartCatalog extends MasterData implements TreeEntity<PartCatalog> {

    private PartCatalog parentNode;
    private Set<PartCatalog> childNodes = new HashSet<PartCatalog>();

    public PartCatalog getParentNode() { return parentNode; }
    public Set<PartCatalog> getChildNodes() { return childNodes; }
}
