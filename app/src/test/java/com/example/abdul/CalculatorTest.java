package com.example.abdul;

import junit.framework.TestCase;

import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest extends TestCase {

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        //initialize variables
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
        //release all resources
    }

    @Test
    public void add() {
        int expected = 40;
        int actual = Calculator.add(10,20);
        assertEquals(expected,actual);
    }
}