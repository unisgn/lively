package com.lively.demo;

import com.lively.service.BusinessPartnerMgr;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by franCiS on Sep 27, 2014.
 * Spring Aop Test
 * @Aspect @link com.lively.aop.BPAop @Before("execution (* doAdd*(..))")
 *
 */


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class AopTest extends AbstractJUnit4SpringContextTests {
    @Autowired
    BusinessPartnerMgr mgr;

    @Test
    public void TestAop() {
        mgr.doAddPartner();
    }
}
