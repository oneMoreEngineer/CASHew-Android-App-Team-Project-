package com.example.cs160cashew;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class BudgetTest extends junit.framework.TestCase {
    Budget budget;
    String name = "Test name";
    Category category = new Category("Test category");
    Category extraCategory = new Category("Extra category");
    List<Category> saved;

    int limit = 240;
    double progress = 240.0;
    int monthDay = 4;

    protected void setUp() {
        budget = new Budget(name, category, limit, progress, monthDay);

    }

    @Test
    public void testGetName() {
        assertEquals(budget.getName(), name);
    }

    @Test
    public void testGetLimit() {
        assertEquals(budget.getLimit(), limit);
    }

    @Test
    public void testGetCategory() {
        assertFalse(budget.getCategoryList().isEmpty());
    }

    @Test
    public void testAddCategory() throws Exception {
        saved = budget.getCategoryList();
        budget.addCategory(extraCategory);
        assertNotEquals(budget.getCategoryList(), saved);
    }

}