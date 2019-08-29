package com.github.shoothzj.algorithm.leetcode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q0992 {

    private static final Logger log = LoggerFactory.getLogger(Q0992.class);

    public int subarrayWithKDistinct(int[] A, int K) {
        List<Set<Integer>> setList = new ArrayList<>();
        int result = 0;
        for (int i = 0; i < A.length; i++) {
            HashSet<Integer> hashSet = new HashSet<>();
            hashSet.add(A[i]);
            setList.add(hashSet);
        }
        if (K == 1) {
            result += A.length;
        }
        for (int i = 1; i < A.length; i++) {
            List<Set<Integer>> newList = new ArrayList<>();
            for (int j = i; j < A.length; j++) {
                Set<Integer> integers = setList.get(j - i);
                Set<Integer> integers1 = setList.get(j - i + 1);
                integers.addAll(integers1);
                newList.add(integers);
                if (integers.size() == K) {
                    result++;
                }
            }
            setList = newList;
        }
        return result;
    }

}