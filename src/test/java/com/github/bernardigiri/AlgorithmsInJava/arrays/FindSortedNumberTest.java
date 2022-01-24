package com.github.bernardigiri.AlgorithmsInJava.arrays;

import org.junit.Test;

import static org.junit.Assert.*;

public class FindSortedNumberTest {
    @Test
    public void findGreatestNumberEqualToOrLessThanX() throws Exception {
        int []array = new int[]{
                1, 2, 2, 4, 5, 7, 8, 10, 11, 12, 19, 50, 213, 400, 401, 405, 410, 500, 600
        };
        assertEquals(12, FindSortedNumber.findGreatestNumberEqualToOrLessThanX(16, array));
        assertEquals(2, FindSortedNumber.findGreatestNumberEqualToOrLessThanX(2, array));
        assertEquals(1, FindSortedNumber.findGreatestNumberEqualToOrLessThanX(1, array));
        assertEquals(600, FindSortedNumber.findGreatestNumberEqualToOrLessThanX(601, array));
        assertEquals(600, FindSortedNumber.findGreatestNumberEqualToOrLessThanX(1000, array));
        assertEquals(410, FindSortedNumber.findGreatestNumberEqualToOrLessThanX(480, array));
        assertEquals(50, FindSortedNumber.findGreatestNumberEqualToOrLessThanX(100, array));
    }
    @Test
    public void findLowestNumberEqualToOrGreaterThanX() throws Exception {
        int []array = new int[]{
                1, 2, 2, 4, 5, 7, 8, 10, 11, 12, 19, 50, 213, 400, 401, 405, 410, 500, 600
        };
        assertEquals(19, FindSortedNumber.findLowestNumberEqualToOrGreaterThanX(16, array));
        assertEquals(2, FindSortedNumber.findLowestNumberEqualToOrGreaterThanX(2, array));
        assertEquals(1, FindSortedNumber.findLowestNumberEqualToOrGreaterThanX(1, array));
        assertEquals(600, FindSortedNumber.findLowestNumberEqualToOrGreaterThanX(601, array));
        assertEquals(600, FindSortedNumber.findLowestNumberEqualToOrGreaterThanX(1000, array));
        assertEquals(500, FindSortedNumber.findLowestNumberEqualToOrGreaterThanX(480, array));
        assertEquals(213, FindSortedNumber.findLowestNumberEqualToOrGreaterThanX(100, array));
    }
    @Test
    public void findClosestNumberToX() throws Exception {
        int []array = new int[]{
                1, 2, 2, 4, 5, 7, 8, 10, 11, 12, 20, 50, 213, 400, 401, 405, 410, 500, 600
        };
        assertEquals(5, FindSortedNumber.findClosestNumberToX(6, array));
        assertEquals(12, FindSortedNumber.findClosestNumberToX(16, array));
        assertEquals(2, FindSortedNumber.findClosestNumberToX(2, array));
        assertEquals(1, FindSortedNumber.findClosestNumberToX(1, array));
        assertEquals(600, FindSortedNumber.findClosestNumberToX(601, array));
        assertEquals(600, FindSortedNumber.findClosestNumberToX(1000, array));
        assertEquals(500, FindSortedNumber.findClosestNumberToX(480, array));
        assertEquals(50, FindSortedNumber.findClosestNumberToX(100, array));
        assertEquals(213, FindSortedNumber.findClosestNumberToX(200, array));
    }

}