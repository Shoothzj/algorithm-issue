package com.github.shoothzj.algorithm.leetcode.contest;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class Q5175Failure {

    private static final Logger logger = LoggerFactory.getLogger(Q5175Failure.class);

    @Test
    public void test() {
        String substring = "hunu".substring(0, 4);
        canChange(substring, 1);
    }

    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        List<Boolean> result = new ArrayList<>();
        for (int i = 0; i < queries.length; i++) {
            int[] temp = queries[i];
            result.add(canChange(s.substring(temp[0], temp[1] + 1), temp[2]));
        }
        return result;
    }


    private boolean canChange(String str, int footLen) {
        if (str.length() == 1) {
            return true;
        }
        int[] array = new int[26];
        char[] charArray = str.toCharArray();
        for (char c : charArray) {
            array[c - 'a']++;
        }
        int count = 0;
        for (int i = 0; i < 26; i++) {
            count += (array[i] % 2);
            if (count > 2* footLen) {
                return false;
            }
        }
        count /= 2;
        return footLen >= count;
    }

}
