package com.lively.repository;


import com.lively.domain.entity.FinancialAccount;
import com.lively.domain.entity.FinancialAccountType;
import com.lively.domain.entity.User;
import com.lively.exception.BusinessException;
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
public class SpringTest {
    @Autowired
    SessionFactory sessionFactory;

    @Test
    public void test() {
        FinancialAccount ac = new FinancialAccount();
        ac.setNumber("AC#1003");
        ac.setCode(ac.getNumber());
        ac.setName("Cash1");
        ac.setType(FinancialAccountType.CASH);

        FinancialAccount child = new FinancialAccount();
        child.setNumber("AC#1004");
        child.setCode(child.getNumber());
        child.setName("BankAccount2");
        child.setType(FinancialAccountType.CASH);

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        try {
            ac.appendChild(child);
            session.save(ac);
            session.getTransaction().commit();

            session.close();
        } catch (BusinessException e) {
            session.close();
            e.printStackTrace();
        }

//        Person person = new Person();
//        person.setName("John");
//
//        Evend evend = new Evend();
//        evend.setMemo("Evend");
//
//        EvaLabel label = new EvaLabel();
//        label.setAmount(911);
//
//
//        Session session = sessionFactory.openSession();
//        session.beginTransaction();
//        person = (Person) session.load(Person.class, 12);
//        evend.setLabel(label);
//        person.getEvends().add(evend);
//        session.getTransaction().commit();
//        session.close();
    }
}
