package com.lively.domain.entity;

import org.joda.time.DateTime;

import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by franCiS on Oct 01, 2014.
 * Copy of org.springframework.data.jpa.domain.AbstractAuditable
 */
@MappedSuperclass
public abstract class AbstractAuditable<PK extends Serializable>
        extends AbstractPersistable<PK>
        implements Auditable<User, PK> {

    private static final long serialVersionUID = 141481953116476081L;

    @ManyToOne
    private User createdBy;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @ManyToOne
    private User lastModifiedBy;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    /*
     * (non-Javadoc)
     *
     * @see org.springframework.data.domain.Auditable#getCreatedBy()
     */
    public User getCreatedBy() {

        return createdBy;
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * org.springframework.data.domain.Auditable#setCreatedBy(java.lang.Object)
     */
    public void setCreatedBy(final User createdBy) {

        this.createdBy = createdBy;
    }

    /*
     * (non-Javadoc)
     *
     * @see org.springframework.data.domain.Auditable#getCreatedDate()
     */
    public DateTime getCreatedDate() {

        return null == createdDate ? null : new DateTime(createdDate);
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * org.springframework.data.domain.Auditable#setCreatedDate(org.joda.time
     * .DateTime)
     */
    public void setCreatedDate(final DateTime createdDate) {

        this.createdDate = null == createdDate ? null : createdDate.toDate();
    }

    /*
     * (non-Javadoc)
     *
     * @see org.springframework.data.domain.Auditable#getLastModifiedBy()
     */
    public User getLastModifiedBy() {

        return lastModifiedBy;
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * org.springframework.data.domain.Auditable#setLastModifiedBy(java.lang
     * .Object)
     */
    public void setLastModifiedBy(final User lastModifiedBy) {

        this.lastModifiedBy = lastModifiedBy;
    }

    /*
     * (non-Javadoc)
     *
     * @see org.springframework.data.domain.Auditable#getLastModifiedDate()
     */
    public DateTime getLastModifiedDate() {

        return null == lastModifiedDate ? null : new DateTime(lastModifiedDate);
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * org.springframework.data.domain.Auditable#setLastModifiedDate(org.joda
     * .time.DateTime)
     */
    public void setLastModifiedDate(final DateTime lastModifiedDate) {

        this.lastModifiedDate = null == lastModifiedDate ? null : lastModifiedDate.toDate();
    }
}
