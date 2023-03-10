package org.google.foobar;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class Solution3 {
    public static int solution(int[] nums) {
        List<Integer> numList = new ArrayList<Integer>();
        for (int num : nums) {
            numList.add(num);
        }
        Collections.sort(numList, Collections.reverseOrder());
        for (int i = nums.length; i >= 1; i--) {
            for (List<Integer> tup : possibleCombinations(numList, i)) {
                if (sumList(tup) % 3 == 0) {
                    return joinList(tup);
                }
            }
        }
        return 0;
    }

    public static <T> List<List<T>> possibleCombinations(List<T> lst, int n) {
        List<List<T>> result = new ArrayList<List<T>>();
        if (n == 0) {
            result.add(new ArrayList<T>());
            return result;
        }
        for (int i = 0; i < lst.size(); i++) {
            T elem = lst.get(i);
            List<T> subLst = lst.subList(i + 1, lst.size());
            for (List<T> subC : possibleCombinations(subLst, n - 1)) {
                List<T> newList = new ArrayList<T>();
                newList.add(elem);
                newList.addAll(subC);
                result.add(newList);
            }
        }
        return result;
    }

    public static int sumList(List<Integer> lst) {
        int sum = 0;
        for (int num : lst) {
            sum += num;
        }
        return sum;
    }

    public static int joinList(List<Integer> lst) {
        StringBuilder sb = new StringBuilder();
        for (int num : lst) {
            sb.append(num);
        }
        return Integer.parseInt(sb.toString());
    }

    public static void main(String[] args){
        System.out.println(Solution3.solution(new int[]{3, 1, 4, 1, 5, 9}));
        System.out.println(Solution3.solution(new int[]{3, 1, 4, 1}));
    }
}