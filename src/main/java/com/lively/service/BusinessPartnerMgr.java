package com.lively.service;

import com.lively.domain.entity.BusinessPartner;

/**
 * Created by franCiS on Sep 21, 2014.
 */
public interface BusinessPartnerMgr extends MasterDataService<BusinessPartner> {
    public void doAddPartner();
}
