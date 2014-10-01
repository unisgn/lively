package com.lively.domain.entity;

import org.joda.time.DateTime;

import java.io.Serializable;

/**
 * Created by franCiS on Oct 01, 2014.
 * Copy of org.springframework.data.domain.Auditable
 */
public interface Auditable<U, ID extends Serializable> extends Persistable<ID> {

    /**
     * Returns the user who created this entity.
     *
     * @return the createdBy
     */
    U getCreatedBy();

    /**
     * Sets the user who created this entity.
     *
     * @param createdBy the creating entity to set
     */
    void setCreatedBy(final U createdBy);

    /**
     * Returns the creation date of the entity.
     *
     * @return the createdDate
     */
    DateTime getCreatedDate();

    /**
     * Sets the creation date of the entity.
     *
     * @param creationDate the creation date to set
     */
    void setCreatedDate(final DateTime creationDate);

    /**
     * Returns the user who modified the entity lastly.
     *
     * @return the lastModifiedBy
     */
    U getLastModifiedBy();

    /**
     * Sets the user who modified the entity lastly.
     *
     * @param lastModifiedBy the last modifying entity to set
     */
    void setLastModifiedBy(final U lastModifiedBy);

    /**
     * Returns the date of the last modification.
     *
     * @return the lastModifiedDate
     */
    DateTime getLastModifiedDate();

    /**
     * Sets the date of the last modification.
     *
     * @param lastModifiedDate the date of the last modification to set
     */
    void setLastModifiedDate(final DateTime lastModifiedDate);
}
