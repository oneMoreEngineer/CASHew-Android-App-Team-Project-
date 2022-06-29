package com.example.cs160cashew;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class UserTest extends junit.framework.TestCase{
    User user;
    String name = "Test";
    List<Budget> testList = new ArrayList<>();

    protected void setUp() {
        user = new User(name);
    }

    @Test
    public void testGetName() {
        assertEquals(user.getName(), name);
    }

    @Test
    public void testGetBudgetList() {
        user.setBudgetList(testList);
        assertEquals(user.getBudgetList(), testList);
    }

    @Test
    public void testAddBudget() {


        user.addBudget(new Budget("Test Budget", new Category("Test Category"), 240, 240.0, 4));


        assertNotEquals(user.getBudgetList(), testList);
    }
}