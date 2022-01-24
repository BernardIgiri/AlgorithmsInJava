package com.github.bernardigiri.AlgorithmsInJava.arrays;

public class FindSortedNumber {
    public static int findGreatestNumberEqualToOrLessThanX(int x, int []sortedArray) {
        return searchGreatest(0, sortedArray.length, sortedArray, x);
    }

    public static int findLowestNumberEqualToOrGreaterThanX(int x, int []sortedArray) {
        return searchLowest(0, sortedArray.length, sortedArray, x);
    }

    public static int findClosestNumberToX(int x, int []sortedArray) {
        return searchClosest(0, sortedArray.length, sortedArray, x);
    }

    private static int searchGreatest(int iStart, int iEnd, int []a, int v) {
        while (iStart < iEnd) {
            int iMid = (iEnd - iStart)/2 + iStart;
            int c = a[iMid];
            if (c == v) {
                return c;
            } else if (c < v) {
                iStart = iMid + 1;
            } else {
                iEnd = iMid - 1;
            }
        }
        int i = Math.min(a.length -1, iStart);
        int c = a[i];
        if (c > v && i > 0) {
            return a[i -1];
        } else {
            return c;
        }
    }

    private static int searchLowest(int iStart, int iEnd, int []a, int v) {
        while (iStart < iEnd) {
            int iMid = (iEnd - iStart)/2 + iStart;
            int c = a[iMid];
            if (c == v) {
                return c;
            } else if (c < v) {
                iStart = iMid + 1;
            } else {
                iEnd = iMid - 1;
            }
        }
        int i = Math.min(a.length -1, iStart);
        int c = a[i];
        if (c >= v) {
            return c;
        } else {
            i = Math.min(a.length -1, iStart + 1);
            c = a[i];
            return c;
        }
    }

    private static int searchClosest(int iStart, int iEnd, int []a, int v) {
        while (iStart < iEnd) {
            int iMid = (iEnd - iStart)/2 + iStart;
            int c = a[iMid];
            if (c == v) {
                return c;
            } else if (c < v) {
                iStart = iMid + 1;
            } else {
                iEnd = iMid - 1;
            }
        }
        int iMid = Math.min(a.length -1, iStart);
        iStart = Math.max(0, iStart -1);
        iEnd = Math.min(a.length -1, iEnd +1);
        int distanceStart = Math.abs(a[iStart] - v);
        int distanceMid = Math.abs(a[iMid] - v);
        int distanceEnd = Math.abs(a[iEnd] - v);
        int closest = Math.min(distanceStart, Math.min(distanceMid, distanceEnd));
        if (closest == distanceStart) {
            return a[iStart];
        } else if (closest == distanceMid) {
            return a[iMid];
        } else {
            return a[iEnd];
        }
    }
}
