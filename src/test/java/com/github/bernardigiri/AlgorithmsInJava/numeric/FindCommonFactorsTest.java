package com.github.bernardigiri.AlgorithmsInJava.numeric;

import org.junit.Test;

import static org.junit.Assert.*;

public class FindCommonFactorsTest {
    @Test
    public void GCF() throws Exception {
        assertEquals(31, FindCommonFactors.GCF(3007,2077));
        assertEquals(31, FindCommonFactors.GCF(2077,3007));
        assertEquals(42, FindCommonFactors.GCF(378,42));
        assertEquals(42, FindCommonFactors.GCF(42,378));
        assertEquals(42, FindCommonFactors.GCF(42,42));
        assertEquals(0, FindCommonFactors.GCF(0,0));
        assertEquals(1, FindCommonFactors.GCF(17,3));
        assertEquals(1, FindCommonFactors.GCF(3,17));
        assertEquals(3, FindCommonFactors.GCF(300,3));
        assertEquals(3, FindCommonFactors.GCF(3,300));
    }

}