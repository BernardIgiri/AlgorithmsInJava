package com.github.bernardigiri.AlgorithmsInJava.arrays;

import org.junit.Test;

import static org.junit.Assert.*;

public class CommonSequence {
    @Test
    public void longestCommonSubSequence() throws Exception {
        assertEquals("abcf", CommonSubsequence.longestCommonSubSequence("acbcf", "abcdaf"));
        assertEquals("abcdef", CommonSubsequence.longestCommonSubSequence("abcdef", "abcdef"));
        assertEquals("abcdef", CommonSubsequence.longestCommonSubSequence("abcdefg", "abcdef"));
        assertEquals("cdef", CommonSubsequence.longestCommonSubSequence("abcdefg", "cdef"));
        assertEquals("ab", CommonSubsequence.longestCommonSubSequence("abababa", "ab"));
        assertEquals("aba", CommonSubsequence.longestCommonSubSequence("abababa", "abad"));
        assertEquals("abcab", CommonSubsequence.longestCommonSubSequence("abacabad", "dabcab"));
        assertEquals("cdefg", CommonSubsequence.longestCommonSubSequence("abcdefg", "cdefg"));
        assertEquals("abc", CommonSubsequence.longestCommonSubSequence("abcdefg", "abc"));
    }

    @Test
    public void longestCommonSubstring() throws Exception {
        assertEquals("bc", CommonSubsequence.longestCommonSubstring("acbcf", "abcdaf"));
        assertEquals("abcdef", CommonSubsequence.longestCommonSubstring("abcdef", "abcdef"));
        assertEquals("abcdef", CommonSubsequence.longestCommonSubstring("abcdefg", "abcdef"));
        assertEquals("cdef", CommonSubsequence.longestCommonSubstring("abcdefg", "cdef"));
        assertEquals("ab", CommonSubsequence.longestCommonSubstring("abababa", "ab"));
        assertEquals("aba", CommonSubsequence.longestCommonSubstring("abababa", "abad"));
        assertEquals("cab", CommonSubsequence.longestCommonSubstring("abacabad", "dabcab"));
        assertEquals("cdefg", CommonSubsequence.longestCommonSubstring("abcdefg", "cdefg"));
        assertEquals("abc", CommonSubsequence.longestCommonSubstring("abcdefg", "abc"));
    }
}