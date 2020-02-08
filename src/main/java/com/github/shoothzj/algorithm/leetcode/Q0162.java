package com.github.shoothzj.algorithm.leetcode;

import org.junit.jupiter.api.Test;

public class Q0162 {

    @Test
    public void doIt() {
        int[] array = new int[]{1, 2, 3, 1};
        int res = findPeakElement(array);
        System.out.println(res);
    }

    public int findPeakElement(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        //check its self border
        if (nums[0] > nums[1]) {
            return 0;
        }
        if (nums[nums.length - 1] > nums[nums.length - 2]) {
            return nums.length - 1;
        }
        //分治法处理, this step nums.length must large than three
        return findPeakElement(nums, 1, nums.length - 2, nums[0], nums[nums.length - 1]);
    }

    private int findPeakElement(int[] array, int lIdx, int rIdx, int lVal, int rVal) {
        if (rIdx == lIdx) {
            if (array[rIdx] > lVal && array[lIdx] > rVal) {
                return rIdx;
            } else {
                return -1;
            }
        }
        int mid = lIdx + (rIdx - lIdx) / 2;
        int leftRes = findPeakElement(array, lIdx, mid, array[lIdx - 1], array[mid + 1]);
        int rightRes = findPeakElement(array, mid + 1, rIdx, array[mid], array[rIdx + 1]);
        if (leftRes != -1) {
            return leftRes;
        } else if (rightRes != -1) {
            return rightRes;
        }
        return -1;
    }

}
