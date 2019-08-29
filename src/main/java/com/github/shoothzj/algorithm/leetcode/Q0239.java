package com.github.shoothzj.algorithm.leetcode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 *
 * 返回滑动窗口中的最大值。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sliding-window-maximum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * https://leetcode-cn.com/problems/sliding-window-maximum/
 */
//todo
public class Q0239 {

    private static final Logger logger = LoggerFactory.getLogger(Q0239.class);

    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> indexDeque = new LinkedList<>();
        Deque<Integer> valueDeque = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            if (indexDeque.peekLast() == null) {
                indexDeque.push(i);
                valueDeque.push(nums[i]);
            }
        }
        return new int[]{};
    }

}
