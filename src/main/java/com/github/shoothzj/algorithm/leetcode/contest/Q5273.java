package com.github.shoothzj.algorithm.leetcode.contest;

import com.github.shoothzj.algorithm.leetcode.LeetCodeUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hezhangjian
 */
@Slf4j
public class Q5273 {

    @Test
    public void test() {
        List<List<String>> list = suggestedProducts(LeetCodeUtil.convertToStringArray("[\"mobile\",\"mouse\",\"moneypot\",\"monitor\",\"mousepad\"]"), "mouse");
        System.out.println(list);
    }

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> result = new ArrayList<>();
        TrieTree root = new TrieTree("");
        for (String s : products) {
            root.add(s, 0);
        }
        char[] chars = searchWord.toCharArray();
        for (char ch : chars) {
            if (root == null) {
                result.add(new ArrayList<>());
                continue;
            }
            TrieTree nextRoot = root.nodeArray[ch - 'a'];
            if (nextRoot == null) {
                root = null;
                result.add(new ArrayList<>());
                continue;
            }
            result.add(nextRoot.getTop(3));
            root = nextRoot;
        }
        return result;
    }

    static class TrieTree {

        int total = 0;

        int end = 0;

        TrieTree[] nodeArray = new TrieTree[26];

        String prefix;

        public TrieTree(String prefix) {
            this.prefix = prefix;
        }

        public void add(String word, int index) {
            total++;
            char ch = word.charAt(index);
            if (index == word.length() - 1) {
                //that's the end
                if (nodeArray[ch - 'a'] == null) {
                    TrieTree node = new TrieTree(prefix + ch);
                    nodeArray[ch - 'a'] = node;
                }
                nodeArray[ch - 'a'].end++;
            } else {
                //need recursive
                if (nodeArray[ch - 'a'] == null) {
                    TrieTree node = new TrieTree(prefix + ch);
                    nodeArray[ch - 'a'] = node;
                }
                nodeArray[ch - 'a'].add(word, index + 1);
            }
        }

        public List<String> getTop(int num) {
            List<String> result = new ArrayList<>();
            for (int i = 0; i < Math.min(end, num); i++) {
                result.add(this.prefix);
            }
            if (end >= num) {
                return result;
            }
            int remaining = num - end;
            for (TrieTree trieTree : nodeArray) {
                if (trieTree == null) {
                    continue;
                }
                if (trieTree.total + trieTree.end >= remaining) {
                    result.addAll(trieTree.getTop(remaining));
                    break;
                } else {
                    result.addAll(trieTree.getTop(trieTree.total + trieTree.end));
                    remaining -= (trieTree.total + trieTree.end);
                }
            }
            return result;
        }

    }


}
