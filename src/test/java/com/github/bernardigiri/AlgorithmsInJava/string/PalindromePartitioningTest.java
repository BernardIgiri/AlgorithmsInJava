package com.github.bernardigiri.AlgorithmsInJava.string;

import org.hamcrest.CoreMatchers;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class PalindromePartitioningTest {

    private Set<String> mapResults(List<List<String>> results) {
        Set<String> set = new HashSet<>();
        for (List<String> partition:results) {
            String joined = String.join(",", partition);
            set.add(joined);
        }
        return set;
    }

    @Test
    public void partitionPalindromesConditionAAAA() throws Exception {
        List<List<String>> result = PalindromePartitioning.partitionPalindromes("aaaa");
        Set<String> resultSet = mapResults(result);
        List<String> expected = Arrays.asList(new String[]{
                "a,a,a,a",
                "aa,a,a",
                "a,aa,a",
                "a,a,aa",
                "a,aaa",
                "aaa,a",
                "aa,aa",
                "aaaa",
        });
        for (String e:expected) {
            assertTrue(e, resultSet.contains(e));
        }
        assertEquals(expected.size(), result.size());
    }

    @Test
    public void partitionPalindromesConditionAABB() throws Exception {
        List<List<String>> result = PalindromePartitioning.partitionPalindromes("aabb");
        Set<String> resultSet = mapResults(result);
        List<String> expected = Arrays.asList(new String[]{
                "a,a,b,b",
                "aa,b,b",
                "a,a,bb",
                "aa,bb",
        });
        for (String e:expected) {
            assertTrue(e, resultSet.contains(e));
        }
        assertEquals(expected.size(), result.size());
    }

    @Test
    public void partitionPalindromesConditionAAB() throws Exception {
        List<List<String>> result = PalindromePartitioning.partitionPalindromes("aab");
        Set<String> resultSet = mapResults(result);
        List<String> expected = Arrays.asList(new String[]{
                "a,a,b",
                "aa,b",
        });
        for (String e:expected) {
            assertTrue(e, resultSet.contains(e));
        }
        assertEquals(expected.size(), result.size());
    }

    @Test
    public void partitionPalindromesConditionBAA() throws Exception {
        List<List<String>> result = PalindromePartitioning.partitionPalindromes("baa");
        Set<String> resultSet = mapResults(result);
        List<String> expected = Arrays.asList(new String[]{
                "b,a,a",
                "b,aa",
        });
        for (String e:expected) {
            assertTrue(e, resultSet.contains(e));
        }
        assertEquals(expected.size(), result.size());
    }

    @Test
    public void partitionPalindromesConditionAABAA() throws Exception {
        List<List<String>> result = PalindromePartitioning.partitionPalindromes("aabaa");
        Set<String> resultSet = mapResults(result);
        List<String> expected = Arrays.asList(new String[]{
                "a,a,b,a,a",
                "aa,b,a,a",
                "a,a,b,aa",
                "a,aba,a",
                "aa,b,aa",
                "aabaa"
        });
        for (String e:expected) {
            assertTrue(e, resultSet.contains(e));
        }
        assertEquals(expected.size(), result.size());
    }

    @Test
    public void partitionPalindromesConditionABBA() throws Exception {
        List<List<String>> result = PalindromePartitioning.partitionPalindromes("abba");
        Set<String> resultSet = mapResults(result);
        List<String> expected = Arrays.asList(new String[]{
                "a,b,b,a",
                "a,bb,a",
                "abba",
        });
        for (String e:expected) {
            assertTrue(e, resultSet.contains(e));
        }
        assertEquals(expected.size(), result.size());
    }

    @Test
    public void partitionPalindromesConditionABB() throws Exception {
        List<List<String>> result = PalindromePartitioning.partitionPalindromes("abb");
        Set<String> resultSet = mapResults(result);
        List<String> expected = Arrays.asList(new String[]{
                "a,b,b",
                "a,bb",
        });
        for (String e:expected) {
            assertTrue(e, resultSet.contains(e));
        }
        assertEquals(expected.size(), result.size());
    }

    @Test
    public void partitionPalindromesConditionABCBD() throws Exception {
        List<List<String>> result = PalindromePartitioning.partitionPalindromes("abcbd");
        Set<String> resultSet = mapResults(result);
        List<String> expected = Arrays.asList(new String[]{
                "a,b,c,b,d",
                "a,bcb,d",
        });
        for (String e:expected) {
            assertTrue(e, resultSet.contains(e));
        }
        assertEquals(expected.size(), result.size());
    }

    @Test
    public void partitionPalindromesConditionABCBDBCDA() throws Exception {
        List<List<String>> result = PalindromePartitioning.partitionPalindromes("abcbdbcda");
        Set<String> resultSet = mapResults(result);
        List<String> expected = Arrays.asList(new String[]{
                "a,b,c,b,d,b,c,d,a",
                "a,bcb,d,b,c,d,a",
                "a,b,c,bdb,c,d,a",
                "a,b,cbdbc,d,a",
        });
        for (String e:expected) {
            assertTrue(e, resultSet.contains(e));
        }
        assertEquals(expected.size(), result.size());
    }

    @Test
    public void partitionPalindromesConditionABACABA() throws Exception {
        List<List<String>> result = PalindromePartitioning.partitionPalindromes("abacaba");
        Set<String> resultSet = mapResults(result);
        List<String> expected = Arrays.asList(new String[]{
                "a,b,a,c,a,b,a",
                "aba,c,a,b,a",
                "a,b,aca,b,a",
                "a,b,a,c,aba",
                "aba,c,aba",
                "a,bacab,a",
                "abacaba",
        });
        for (String e:expected) {
            assertTrue(e, resultSet.contains(e));
        }
        assertEquals(expected.size(), result.size());
    }
}