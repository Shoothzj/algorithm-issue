package com.github.shoothzj.algorithm.leetcode;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 给你一份『词汇表』（字符串数组） words 和一张『字母表』（字符串） chars。
 *
 * 假如你可以用 chars 中的『字母』（字符）拼写出 words 中的某个『单词』（字符串），那么我们就认为你掌握了这个单词。
 *
 * 注意：每次拼写时，chars 中的每个字母都只能用一次。
 *
 * 返回词汇表 words 中你掌握的所有单词的 长度之和。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-words-that-can-be-formed-by-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * 示例 1：
 *
 * 输入：words = ["cat","bt","hat","tree"], chars = "atach"
 * 输出：6
 * 解释：
 * 可以形成字符串 "cat" 和 "hat"，所以答案是 3 + 3 = 6。
 * 示例 2：
 *
 * 输入：words = ["hello","world","leetcode"], chars = "welldonehoneyr"
 * 输出：10
 * 解释：
 * 可以形成字符串 "hello" 和 "world"，所以答案是 5 + 5 = 10。
 *  
 *
 * 提示：
 *
 * 1 <= words.length <= 1000
 * 1 <= words[i].length, chars.length <= 100
 * 所有字符串中都仅包含小写英文字母
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-words-that-can-be-formed-by-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q1160 {

    private static final Logger logger = LoggerFactory.getLogger(Q1160.class);

    @Test
    public void test() {
//        countCharacters(new String[]{"hello","world","leetcode"}, "welldonehoneyr");
        countCharacters(new String[]{"cat","bt","hat","tree"}, "atach");
    }

    public int countCharacters(String[] words, String chars) {
        int[] countArray = new int[26];
        char[] charArray = chars.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            countArray[charArray[i] - 'a']++;
        }
        int result = 0;
        for (int i = 0; i < words.length; i++) {
            String word = words[i];

            char[] wordArray = word.toCharArray();
            int[] compareArray = new int[26];
            for (int j = 0; j < wordArray.length; j++) {
                int index = wordArray[j] - 'a';
                compareArray[index]++;
                if (compareArray[index] > countArray[index]) {
                    break;
                }
                if (j == wordArray.length - 1) {
                    result += word.length();
                }
            }
        }

        return result;
    }

}
