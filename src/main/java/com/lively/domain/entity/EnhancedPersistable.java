package com.lively.domain.entity;

import java.io.Serializable;

/**
 * Created by franCiS on Sep 22, 2014.
 */
public interface EnhancedPersistable<ID extends Serializable> extends Persistable<ID> {
    public String getResid();
    public int getVersion();
    public boolean isActive();
    public boolean isArchived();
    public void setResid(String resid);
    public void setActive(boolean active);
    public void setArchived(boolean archived);
}
