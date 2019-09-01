package com.github.shoothzj.algorithm.leetcode.contest;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Q5174 {

    private static final Logger logger = LoggerFactory.getLogger(Q5174.class);

    @Test
    public void test() {
        int res = dietPlanPerformance(new int[]{6, 13, 8, 7, 10, 1, 12, 11}, 6, 5, 37);
        System.out.println(res);
    }

    public int dietPlanPerformance(int[] calories, int k, int lower, int upper) {
        int result = 0;
        for (int index = 0; index < (calories.length - k + 1); index++) {
            int aux = 0;
            for (int i = index; i < index + k && i < calories.length; i++) {
                aux += calories[i];
            }
            if (aux > upper) {
                result += 1;
            } else if (aux < lower) {
                result -= 1;
            }
        }


        return result;
    }

}
