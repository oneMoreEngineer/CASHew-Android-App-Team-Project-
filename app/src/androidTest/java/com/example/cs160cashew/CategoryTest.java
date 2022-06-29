package com.example.cs160cashew;

import static org.junit.Assert.*;

import org.junit.Test;

public class CategoryTest extends junit.framework.TestCase{
    Category category;
    String name = "Test category";
    int spending = 24;

    protected void setUp() {
        category = new Category(name);
    }

    @Test
    public void testGetName() {
        assertEquals(category.getName(), name);
    }

    @Test
    public void testGetSpending() {
        category.setSpending(spending);
        assertEquals(category.getSpending(), spending);
    }
}

