package com.lively.repository;

import com.lively.domain.entity.BusinessPartner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.*;
import java.util.List;

/**
 * Created by franCiS on Sep 27, 2014.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class BusinessPartnerRepositoryTest {
    @Autowired
    BusinessPartnerRepository bpRepo;

    @Test
    public void testie() {
//        BusinessPartner bp = new BusinessPartner();
//        bp.setNumber("BP#003");
//        bpRepo.save(bp);



//        List<BusinessPartner> list = bpRepo.search("Hello");
//        assertThat(list, notNullValue());
//        assertThat(list.size(), equalTo(1));
//        assertThat(list.get(0).getNumber(), equalTo("BP#002"));
    }
}
