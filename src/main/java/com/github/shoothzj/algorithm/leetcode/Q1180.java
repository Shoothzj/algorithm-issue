package com.github.shoothzj.algorithm.leetcode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Q1180 {

    private static final Logger logger = LoggerFactory.getLogger(Q1180.class);

    public int countLetters(String S) {
        int result = 0;
        int auxCount = 0;
        char lastChar = 'A';
        char[] charArray = S.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char ch = charArray[i];
            if (ch == lastChar) {
                auxCount++;
            } else {
                result += cal(auxCount);
                auxCount = 1;
                lastChar = ch;
            }
        }
        result += cal(auxCount);
        return result;
    }

    private int cal(int count) {
        return count * (count + 1) / 2;
    }

}
