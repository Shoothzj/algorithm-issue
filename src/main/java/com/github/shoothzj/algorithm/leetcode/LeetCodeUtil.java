package com.github.shoothzj.algorithm.leetcode;

public class LeetCodeUtil {

    //[[0,11,0,0],[0,1,0,0],[0,0,0,0],[0,0,1,0],[0,0,0,0]]
    public static int[][] convertToTwoArray(String src) {
        src = src.trim();
        String[] split = src.split("],");
        int n = split[0].split(",").length;

        char[] array = src.toCharArray();
        StringBuilder aux = new StringBuilder();
        for (char ch: array) {
            if (ch == '[' || ch == ']') {
                continue;
            }
            aux.append(ch);
        }
        String[] splitArray = aux.toString().split(",");
        int total = splitArray.length;
        int m = total / n;

        int[][] res = new int[m][n];
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res[i][j] = Integer.parseInt(splitArray[count++]);
            }
        }

        return res;
    }

    public static int[] convertToIntArray(String src) {
        src = src.trim();
        String aux = src.substring(1, src.length() - 1);
        String[] split = aux.split(",");
        int[] result = new int[split.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = Integer.parseInt(split[i]);
        }
        return result;
    }

    //todo
    public static String[] convertToStringArray(String src) {
        src = src.trim();
        String aux = src.substring(1, src.length() - 1);
        return aux.split(",");
    }

}
