package com.github.bernardigiri.AlgorithmsInJava.string;

import java.util.ArrayList;

public class MatchRegEx {

    public static boolean match(String regex, String target) {
        if (regex.length() == 0) {
            return target.length() == 0;
        } else {
            ArrayList<RegexTerm> regexTermList = new ArrayList<>();
            for (int i=0; i<regex.length(); i++) {
                boolean isStar = false;
                char c = regex.charAt(i);
                if (i<regex.length()-1 && regex.charAt(i+1) == '*') {
                    isStar = true;
                    i++;
                }
                RegexTerm term = new RegexTerm(c, isStar);
                regexTermList.add(term);
            }
            return recurse(regexTermList, target, 0, 0);
        }
    }

    static private boolean recurse(ArrayList<RegexTerm> regexTermList, String target, int rIdx, int tIdx) {
        for (; rIdx < regexTermList.size() && tIdx < target.length(); rIdx++) {
            RegexTerm term = regexTermList.get(rIdx);
            if (term.isStar()) {
                if (recurse(regexTermList, target, rIdx +1, tIdx)) {
                    return true;
                } else if (term.isMatch(target.charAt(tIdx))) {
                    tIdx++;
                    rIdx--;
                }
            } else if (term.isMatch(target.charAt(tIdx))) {
                tIdx++;
            } else {
                return false;
            }
        }
        while (rIdx < regexTermList.size() && tIdx == target.length()) {
            RegexTerm term = regexTermList.get(rIdx);
            if (term.isStar()) {
                rIdx++;
            } else {
                return false;
            }
        }
        return rIdx == regexTermList.size() && tIdx == target.length();
    }


    private static class RegexTerm {
        private final char character;
        final boolean isStar;

        private RegexTerm(char character, boolean isStar){
            this.character = character;
            this.isStar = isStar;
        }

        public boolean isStar() {
            return isStar;
        }

        public boolean isMatch(char other) {
            return character == '.' || other == character;
        }
    }

}
