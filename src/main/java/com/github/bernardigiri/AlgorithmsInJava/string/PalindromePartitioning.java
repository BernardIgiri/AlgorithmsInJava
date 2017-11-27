package com.github.bernardigiri.AlgorithmsInJava.string;

import java.util.ArrayList;
import java.util.List;

/**
 * Find all possible partitionings of a string where all partitions are palindromes
 */
public class PalindromePartitioning {

    public static List<List<String>> partitionPalindromes(String text) {
        List<List<String>> palindromes = new ArrayList<>();
        boolean [][] substringMatrix = new boolean[text.length()][text.length()];
        for (int i=0; i<text.length(); i++) {
            for (int j=i +1; j<=text.length(); j++) {
                substringMatrix[i][j-1] = isPalindrome(text, i, j-1);
            }
        }
        for (int j=0 +1; j<=text.length(); j++) {
            if (substringMatrix[0][j-1]) {
                List<String> partition = new ArrayList<>();
                partition.add(text.substring(0, j));
                buildPartition(j, text, substringMatrix, partition, palindromes);
            };
        }
        return palindromes;
    }

    private static void buildPartition(int start, String text, boolean [][] substringMatrix, List<String> partition, List<List<String>> palindromes) {
        if (start == text.length()) {
            palindromes.add(partition);
        } else {
            for (int j = start + 1; j <= text.length(); j++) {
                if (substringMatrix[start][j - 1]) {
                    List<String> newPartition = new ArrayList<>(partition);
                    newPartition.add(text.substring(start, j));
                    buildPartition(j, text, substringMatrix, newPartition, palindromes);
                }
            }
        }
    }

    private static boolean isPalindrome(String text, int begin, int end) {
        for (; begin < end; begin++, end--) {
            if (text.charAt(begin) != text.charAt(end)) {
                return false;
            }
        }
        return true;
    }
}
