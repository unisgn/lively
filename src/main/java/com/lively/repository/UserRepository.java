package com.lively.repository;

import com.lively.domain.entity.User;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * Created by franCiS on Oct 04, 2014.
 */
public interface UserRepository extends Repository<User, Integer> {
}
