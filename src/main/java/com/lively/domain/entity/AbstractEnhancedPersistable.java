package com.lively.domain.entity;

import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

/**
 * Created by franCiS on Sep 14, 2014.
 */
@MappedSuperclass
public abstract class AbstractEnhancedPersistable extends AbstractPersistable<Long> implements EnhancedPersistable {


    @Version
    private int version;
    private boolean archived;
    private boolean active;
    private String resid;

    protected AbstractEnhancedPersistable() { }

    public int getVersion() {
        return version;
    }

    protected void setVersion(int version) {
        this.version = version;
    }

    public boolean isArchived() {
        return archived;
    }

    public void setArchived(boolean archived) {
        this.archived = archived;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getResid() {
        return resid;
    }

    public void setResid(String resid) {
        this.resid = resid;
    }
}
