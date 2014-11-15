package com.lively.service;

import com.lively.domain.entity.User;
import com.lively.exception.BusinessException;
import com.lively.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;


import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.*;
/**
 * Created by franCiS on Oct 04, 2014.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
//@TransactionConfiguration(transactionManager = "transactionManager")
public class UserMgrTest {

    @Autowired
    UserMgr mgr;

    @Autowired
    UserRepository repo;

    @Test
//    @Transactional
    public void testSaveUser() {
//        User u1 = new User();
//        u1.setUsername("User#001");
//        User u2 = new User();
//        u2.setUsername("User#002");
//        User u3 = new User();
//        u3.setUsername("User#001");
//        try {
//            mgr.save(u1);
//            mgr.save(u2);
//            assertThat(repo.count(), equalTo(2L));
//            mgr.save(u3);
//            assertThat(repo.count(), equalTo(3L));
//        } catch (BusinessException e) {
//            e.printStackTrace();
//        }
    }
}
