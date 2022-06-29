package com.example.cs160cashew;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class LimitTest extends junit.framework.TestCase {
    Limit limit;
    int amount = 24;

    protected void setUp() {
        limit = new Limit(24);
    }

    @Test
    public void testGetAmount() {
        assertSame(limit.getAmount(), amount);
    }
}