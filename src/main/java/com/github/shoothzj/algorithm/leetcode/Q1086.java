package com.github.shoothzj.algorithm.leetcode;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class Q1086 {

    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(5, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        queue.add(6);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        queue.add(1);
        while (true) {
            Integer poll = queue.poll();
            if (poll == null) {
                break;
            }
            System.out.println(poll);
        }
    }

    @Test
    public void test() {
        highFive(LeetCodeUtil.convertToTwoArray("[[1,91],[1,92],[2,93],[2,97],[1,60],[2,77],[1,65],[1,87],[1,100],[2,100],[2,76]]"));
    }

    public int[][] highFive(int[][] items) {
        TreeMap<Integer, PriorityQueue<Integer>> map = new TreeMap<>();
        for (int i = 0; i < items.length; i++) {
            int index = items[i][0];
            int score = items[i][1];
            PriorityQueue<Integer> queue = map.get(index);
            if (queue == null) {
                queue = new PriorityQueue<>(5, (o1, o2) -> o2 - o1);
            }
            queue.add(score);
            map.put(index, queue);
        }
        int[][] result = new int[map.size()][2];
        for (int i = 1; i <= result.length; i++) {
            PriorityQueue<Integer> queue = map.get(i);
            result[i - 1] = new int[]{i, getAve(queue)};
        }
        return result;
    }

    private int getAve(PriorityQueue<Integer> queue) {
        int count = 5;
        int sum = 0;
        while (count > 0) {
            Integer poll = queue.poll();
            sum += poll;
            count--;
        }
        return sum / 5;
    }

}
