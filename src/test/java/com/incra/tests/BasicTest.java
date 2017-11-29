package com.incra.tests;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class BasicTest extends TestCase {

    @Test
    public void test1() {
        List<String> names = new ArrayList();

        names.add("Jack");
        names.add("Jill");

        assertTrue(names.size() == 2);
    }
}