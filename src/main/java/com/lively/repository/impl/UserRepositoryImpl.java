package com.lively.repository.impl;

import com.lively.domain.entity.User;
import com.lively.repository.UserRepository;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

/**
 * Created by franCiS on Oct 04, 2014.
 */
@Repository
public class UserRepositoryImpl extends RepositoryImpl<User, Integer> implements UserRepository {

}
