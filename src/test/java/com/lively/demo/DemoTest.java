package com.lively.demo;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Before;
import org.junit.Test;


/**
 * Created by franCiS on Sep 21, 2014.
 */

public class DemoTest {

    private String val;

    @Before
    public void setup() {
        val = "JUnit";
    }


    @Test
    public void testDemo() {
        assertThat(val, equalTo("JUnit"));
    }
}
