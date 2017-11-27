package com.github.bernardigiri.AlgorithmsInJava.numeric;

/**
 * Finds the greatest common factors of any two integers
 */
public class FindCommonFactors {
    public static int GCF(int a, int b) {
        int factor = Math.min(a,b);
        if (factor < 1) {
            return 0;
        }
        int mod = Math.max(a,b) % factor;
        while (mod > 0) {
            int previous = factor;
            factor = mod;
            mod = previous%mod;
        }
        return factor;
    }
}
