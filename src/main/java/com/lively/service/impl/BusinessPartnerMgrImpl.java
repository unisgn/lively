package com.lively.service.impl;

import com.lively.domain.entity.BusinessPartner;
import com.lively.repository.BusinessPartnerRepository;
import com.lively.service.BusinessPartnerMgr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by franCiS on Sep 27, 2014.
 */
@Service
public class BusinessPartnerMgrImpl implements BusinessPartnerMgr {

    @Autowired
    BusinessPartnerRepository bpRepo;


    @Override
    public void doAddPartner() {
        System.out.println("Do Adding Partner");
    }

    public BusinessPartner findByNumber(String number) {
        return bpRepo.findByNumber(number);
    }

    public BusinessPartner findByCode(String code) {
        return bpRepo.findByCode(code);
    }
}
