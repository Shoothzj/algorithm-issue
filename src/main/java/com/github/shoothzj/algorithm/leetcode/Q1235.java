package com.github.shoothzj.algorithm.leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class Q1235 {

    public static void main(String[] args) {
        int[] array = new int[]{1,3,5,7,9};
        System.out.println(Arrays.binarySearch(array, 0, 5, 4));
        System.out.println(Arrays.binarySearch(array, 0, 5, 5));

        int i = -9;
        int result = ~i;
        System.out.println(--result);
    }

    //sort the array by endtime
    //and the dp[i] means the max profits can earn at i th end time
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        int[][] jobs = new int[n][3];
        for (int i = 0; i < n; i++) {
            jobs[i][0] = startTime[i];
            jobs[i][1] = endTime[i];
            jobs[i][2] = profit[i];
        }

        Arrays.sort(jobs, Comparator.comparingInt(o -> o[1]));

        int[] end = new int[n];
        for (int i = 0; i < n; i++) {
            end[i] = jobs[i][1];
        }

        int[] dp = new int[n];
        dp[0] = jobs[0][2];
        for (int i = 1; i < n; i++) {
            int index = Arrays.binarySearch(end, 0, i, jobs[i][0]);
            if (index < 0) {
                index = ~index;
                index--;
            }
            dp[i] = Math.max(dp[i - 1], jobs[i][2] + (index >= 0 ? dp[index] : 0));
        }

        return dp[n - 1];
    }

}
