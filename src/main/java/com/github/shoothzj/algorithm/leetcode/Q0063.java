package com.github.shoothzj.algorithm;

import com.github.shoothzj.algorithm.leetcode.LeetCodeUtil;
import org.junit.Test;

public class Q0063 {

    @Test
    public void allObstacle() {
        int i = uniquePathsWithObstacles(LeetCodeUtil.convertToArray("[[0,0,0,0],[0,1,0,0],[0,0,0,0],[0,0,1,0],[0,0,0,0]]"));
//        int i = uniquePathsWithObstacles(new int[][]{ new int[]{0, 0}, new int[]{0, 1}});
        System.out.println(i);
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1] == 1) {
            return 0;
        }
        //memo n means remaining
        int[][] memo = new int[obstacleGrid.length][obstacleGrid[0].length];
        int res = 0;
        for (int i = 0; i < obstacleGrid[0].length; i++) {
            res += dfs(memo, obstacleGrid, 0, i);
        }
        return res;
    }

    private int dfs(int[][] memo, int[][] obstacleGrid, int current, int remaining) {
        if (memo[current][remaining] != 0) {
            return memo[current][remaining];
        }
        if (obstacleGrid[current][remaining] == 1) {
            return 0;
        }
        if (remaining == 0) {
            memo[current][remaining] = 1;
            return 1;
        } else {
            if (current == memo.length - 1) {
                return 0;
            }
            int res = 0;
            //you should know now you're where
            //you are at (current, n - remaining - 1) Point
            //now handle the down stair, it means during you down, can't have 1
            for (int i = 0; i <= remaining; i++) {
                res += dfs(memo, obstacleGrid, current + 1, i);
            }
            memo[current][remaining] = res;
            return res;
        }
    }

}
