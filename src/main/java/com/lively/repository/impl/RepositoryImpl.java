package com.lively.repository.impl;

import com.lively.domain.entity.AbstractPersistable;
import com.lively.domain.entity.User;
import com.lively.repository.Repository;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by franCiS on Oct 04, 2014.
 */
public class RepositoryImpl<E extends Serializable, PK extends Serializable> extends HibernateDaoSupport implements Repository<E, PK> {
    private Class<E> clazz;
    public RepositoryImpl() {
        this.clazz = null;
        Class c = getClass();
        Type t = c.getGenericSuperclass();
        if (t instanceof ParameterizedType) {
            Type[] p = ((ParameterizedType) t).getActualTypeArguments();
            this.clazz = (Class<E>) p[0];
        }
    }

    public E get(PK id) {
        return (E) getHibernateTemplate().get(clazz, id);
    }

    public List<E> findAll() {
        return (List<E>) getHibernateTemplate().loadAll(clazz);
    }

    public E save(E entity) {
        return (E) getHibernateTemplate().save(entity);
    }
}
