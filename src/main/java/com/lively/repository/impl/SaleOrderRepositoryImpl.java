package com.lively.repository.impl;

import com.lively.domain.entity.SaleOrder;
import com.lively.repository.SaleOrderRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by franCiS on Oct 06, 2014.
 */
@Repository
public class SaleOrderRepositoryImpl extends RepositoryImpl<SaleOrder, Long> implements SaleOrderRepository {
}
