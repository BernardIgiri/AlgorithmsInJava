package com.github.bernardigiri.AlgorithmsInJava.string;

import org.junit.Test;

import static org.junit.Assert.*;

public class MatchRegExTest {
    @Test
    public void match() throws Exception {
        assertTrue(MatchRegEx.match(".*", ""));
        assertTrue(MatchRegEx.match("b*", "bbbb"));
        assertTrue(MatchRegEx.match(".*", "adfads"));
        assertTrue(MatchRegEx.match("b*", ""));
        assertTrue(MatchRegEx.match("b*", "b"));
        assertTrue(MatchRegEx.match("ab*", "ab"));
        assertTrue(MatchRegEx.match("ab*", "a"));
        assertTrue(MatchRegEx.match("ab*", "a"));
        assertTrue(MatchRegEx.match("a.b*", "aebbb"));
        assertTrue(MatchRegEx.match("a.", "a7"));
        assertTrue(MatchRegEx.match("", ""));
        assertTrue(MatchRegEx.match("b", "b"));
        assertTrue(MatchRegEx.match("bbb", "bbb"));
        assertTrue(MatchRegEx.match("ba*b", "baab"));
        assertTrue(MatchRegEx.match("ba*b", "bb"));
        assertTrue(MatchRegEx.match("b.*b", "bsadljsdab"));

        assertFalse(MatchRegEx.match("b*", "cb"));
        assertFalse(MatchRegEx.match("b.", "b"));
        assertFalse(MatchRegEx.match("b", "c"));
        assertFalse(MatchRegEx.match("b", "c"));
        assertFalse(MatchRegEx.match("b.*b", "bax"));
        assertFalse(MatchRegEx.match("b.*", "ax"));
        assertFalse(MatchRegEx.match(".*c", "a"));
        assertFalse(MatchRegEx.match(".*c", "as"));
        assertFalse(MatchRegEx.match(".*c", "asf"));
    }

}