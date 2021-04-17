package com.t02;

import com.t01.Calculator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {

    @Before
    public void init(){
        System.out.println("init...");
    }

    @After
    public void close(){
        System.out.println("close...");
    }

    @Test
    public void testAdd(){
        Calculator c = new Calculator();
        int result = c.add(1, 2);
        System.out.println(result);
    }
}
