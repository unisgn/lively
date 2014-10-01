package com.lively.repository;

import com.lively.domain.entity.BusinessPartner;
import org.springframework.data.repository.Repository;

/**
 * Created by franCiS on Sep 21, 2014.
 */
public interface BusinessPartnerRepository extends Repository<BusinessPartner, Long>, MasterDataRepository<BusinessPartner> {
    public BusinessPartner save(BusinessPartner bp);
}
