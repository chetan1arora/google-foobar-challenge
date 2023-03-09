package org.google.foobar;

import java.util.HashSet;
import java.util.Arrays;

public class Solution1 {

    public static int solution(int[] x, int[] y) {
        // Creating a set of worker ids from x
        HashSet<Integer> workerSet = new HashSet<>();
        int[] shortArr, longArr;
        if(y.length > x.length){
            shortArr = x;
            longArr = y;
        }
        else{
            shortArr = y;
            longArr = x;
        }
        for(int i=0; i<shortArr.length; ++i){
            workerSet.add(shortArr[i]);
        }
        // Iterating through the worker ids from y
        return Arrays.stream(longArr).filter(k -> !workerSet.contains(k)).findFirst().orElse(0);
    }

    public static void main(String[] args){
        assert solution(new int[]{13, 5, 6, 2, 5}, new int[]{5, 2, 5, 13}) == 6 : "Failed #1";
        assert solution(new int[]{14, 27, 1, 4, 2, 50, 3, 1}, new int[]{2, 4, -4, 3, 1, 1, 14, 27, 50}) == -4 : "Failed #2";
    }
}
