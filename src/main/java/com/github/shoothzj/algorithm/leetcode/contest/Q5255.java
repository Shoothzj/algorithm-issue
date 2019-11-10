package com.github.shoothzj.algorithm.leetcode.contest;

import lombok.extern.slf4j.Slf4j;

/**
 * @author hezhangjian
 */
@Slf4j
public class Q5255 {

    public int oddCells(int n, int m, int[][] indices) {
        boolean[][] auxArray = new boolean[n][m];
        for (int i = 0; i < indices.length; i++) {
            int x = indices[i][0];
            int y = indices[i][1];

            for (int j = 0; j < m; j++) {
                auxArray[x][j] = !auxArray[x][j];
            }
            for (int j = 0; j < n; j++) {
                auxArray[j][y] = !auxArray[j][y];
            }
        }
        int count = 0;
        for (int i = 0; i < auxArray.length; i++) {
            for (int j = 0; j < auxArray[0].length; j++) {
                if (auxArray[i][j]) {
                    count++;
                }
            }
        }
        return count;
    }

}
