package com.github.shoothzj.algorithm.leetcode;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hezhangjian
 */
@Slf4j
public class Q0320 {

    @Test
    public void test() {
        List<String> word = generateAbbreviations("word");
        System.out.println(word);
    }


    public List<String> generateAbbreviations(String word) {
        String[][] auxArray = new String[word.length() + 1][word.length() + 1];
        char[] charArray = word.toCharArray();
        for (int i = 0; i < word.length(); i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(charArray[i]);
            for (int j = i + 1; j < word.length(); j++) {
                sb.append(charArray[j]);
                auxArray[i][j] = sb.toString();
            }
        }
        for (int i = 0; i <= word.length(); i++) {
            for (int j = 0; j <= word.length(); j++) {
                if (auxArray[i][j] == null) {
                    auxArray[i][j] = "";
                }
            }
        }


        List<String> res = new ArrayList<>();
        res.add(word);
        for (int i = 1; i <= word.length(); i++) {
            for (int j = 0; j <= word.length() - i + 1; j++) {
                res.add(auxArray[0][j] + i + auxArray[j + i][word.length()]);
            }
        }
        return res;
    }

}
