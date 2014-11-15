package com.lively.service.impl;

import com.lively.domain.entity.SaleOrder;
import com.lively.repository.SaleOrderRepository;
import com.lively.service.SaleOrderMgr;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by franCiS on Oct 06, 2014.
 */
public class SaleOrderMgrImpl implements SaleOrderMgr {
    public SaleOrder save(SaleOrder order) {
        return repo.save(order);
    }

    @Autowired
    SaleOrderRepository repo;
}
