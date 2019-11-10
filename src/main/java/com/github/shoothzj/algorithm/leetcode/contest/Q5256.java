package com.github.shoothzj.algorithm.leetcode.contest;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hezhangjian
 */
@Slf4j
public class Q5256 {

    @Test
    public void test() {
        reconstructMatrix(2, 1, new int[]{1, 1, 1});
    }

    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        int twoCount = 0;
        int oneCount = 0;
        for (int i = 0; i < colsum.length; i++) {
            if (colsum[i] == 2) {
                twoCount++;
            } else if (colsum[i] == 1) {
                oneCount++;
            }
        }
        if (upper < twoCount) {
            return new ArrayList<>();
        }
        if (lower < twoCount) {
            return new ArrayList<>();
        }
        if ((2 * twoCount + oneCount) != (upper + lower)) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> upperList = new ArrayList<>();
        List<Integer> lowerList = new ArrayList<>();
        result.add(upperList);
        result.add(lowerList);
        int aux = upper - twoCount;
        for (int i = 0; i < colsum.length; i++) {
            if (colsum[i] == 2) {
                upperList.add(1);
                lowerList.add(1);
            } else if (colsum[i] == 0) {
                upperList.add(0);
                lowerList.add(0);
            } else {
                if (aux > 0) {
                    upperList.add(1);
                    lowerList.add(0);
                    aux--;
                } else {
                    upperList.add(0);
                    lowerList.add(1);
                }
            }
        }

        return result;
    }

}
