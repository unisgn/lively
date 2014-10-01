package com.lively.domain.entity;

import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

/**
 * Created by franCiS on Oct 01, 2014.
 */
public interface EnhancedAuditable<ID extends Serializable> extends Auditable<User, ID> {
    public String getResid();
    public int getVersion();
    public boolean isActive();
    public boolean isArchived();
    public void setResid(String resid);
    public void setActive(boolean active);
    public void setArchived(boolean archived);
}
