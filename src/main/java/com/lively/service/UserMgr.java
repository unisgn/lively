package com.lively.service;

import com.lively.domain.entity.User;
import com.lively.exception.BusinessException;

/**
 * Created by franCiS on Oct 04, 2014.
 */
public interface UserMgr {
    public User save(User user) throws BusinessException;
}
