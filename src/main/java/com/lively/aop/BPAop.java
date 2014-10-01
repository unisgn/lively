package com.lively.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * Created by franCiS on Sep 27, 2014.
 */
@Aspect
@Component
public class BPAop {
    @Before("execution(* doAdd*(..))")
    public void preAdd() {
        System.out.println("=========================================================");
    }
}
