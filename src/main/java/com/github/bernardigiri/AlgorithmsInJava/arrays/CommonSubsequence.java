package com.github.bernardigiri.AlgorithmsInJava.arrays;

import java.util.ArrayList;
import java.util.List;

public class CommonSubsequence {
    public static String longestCommonSubSequence(String a, String b) {
        int matrix[][] = new int[a.length()][b.length()];
        // a => x; b => y
        for (int y=0; y<a.length(); y++) {
            int left = 0;
            for (int x=0; x<b.length(); x++) {
                int up = 0;
                if (y>0) {
                    up = matrix[y-1][x];
                }
                int value = Math.max(left, up);
                if (a.charAt(y) == b.charAt(x)) {
                    value = Math.max(value, up + 1);
                }
                matrix[y][x] = value;
                left = value;
            }
        }
        List<Character> subsequence = new ArrayList<>(Math.min(a.length(), b.length()));
        int y = a.length()-1, x = b.length() -1;
        while (y >= 0 && x >= 0) {
            int left = 0;
            if (x > 0) {
                left = matrix[y][x-1];
            }
            int up = 0;
            if (y > 0) {
                up = matrix[y-1][x];
            }
            int value = matrix[y][x];
            if (value == up) {
                y--;
            } else if (value == left) {
                x--;
            } else {
                subsequence.add(b.charAt(x));
                x--;
                y--;
            }
        }
        StringBuilder sb = new StringBuilder(subsequence.size());
        for (int i = subsequence.size()-1; i >= 0; i--) {
            sb.append(subsequence.get(i));
        }
        return sb.toString();
    }

    public static String longestCommonSubstring(String a, String b) {
        int matrix[][] = new int[a.length()][b.length()];
        int maxValue = 0;
        int maxValueX = 0;
        int maxValueY = 0;
        // a => x; b => y
        for (int y=0; y<a.length(); y++) {
            for (int x=0; x<b.length(); x++) {
                int previous = 0;
                if (y>0 && x>0) {
                    previous = matrix[y-1][x-1];
                }
                int value = 0;
                if (a.charAt(y) == b.charAt(x)) {
                    value = previous + 1;
                }
                matrix[y][x] = value;
                if (value>maxValue) {
                    maxValue = value;
                    maxValueX = x;
                    maxValueY = y;
                }
            }
        }
        List<Character> subsequence = new ArrayList<>(Math.min(a.length(), b.length()));
        int y = maxValueY, x = maxValueX;
        while (x >= 0 && y >= 0) {
            if (matrix[y][x] == 0) {
                break;
            } else {
                subsequence.add(b.charAt(x));
                x--;
                y--;
            }
        }
        StringBuilder sb = new StringBuilder(subsequence.size());
        for (int i = subsequence.size()-1; i >= 0; i--) {
            sb.append(subsequence.get(i));
        }
        return sb.toString();
    }
}
