package com.lively.repository;

import com.lively.domain.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.*;
/**
 * Created by franCiS on Oct 04, 2014.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class UserRepositoryTest {

    @Autowired
    UserRepository repo;

    @Autowired
    SessionFactory sessionFactory;

    @Test
    public void test() {
//        Session session = sessionFactory.openSession();
//        User u = (User) session.get(User.class,7);
//        assertThat(u.getUsername(), equalTo("BP#005"));
    }
}
