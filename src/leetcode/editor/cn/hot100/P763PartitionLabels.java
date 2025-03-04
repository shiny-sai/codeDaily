package leetcode.editor.cn.hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Author: 曹赛
 * Date: 2025/3/4
 * Description:给你一个字符串 s 。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。例如，字符串 "ababcc" 能够被分为 ["abab", "cc"]，但类似 ["aba", "bcc"] 或 ["ab", "ab", "cc"] 的划分是非法的。
 * 注意，划分结果需要满足：将所有划分结果按顺序连接，得到的字符串仍然是 s 。
 * 返回一个表示每个字符串片段的长度的列表。
 */
public class P763PartitionLabels {
    public static void main(String[] args) {

        P763PartitionLabels partitionLabels = new P763PartitionLabels();
        String s = "ababcbacadefegdehijhklij";
        List<Integer> res = partitionLabels.partitionLabels(s);
        System.out.println(Arrays.toString(res.toArray()));
    }

    /**
     * 分割字符串，字母只能出现在一个子串中
     * @param s 给定字符串s
     * @return 返回分割的字符串list
     */
    public List<Integer> partitionLabels(String s) {

        List<Integer> res = new ArrayList<>();
        int len = s.length();
        int[] last = new int[26];   // 存放26个英文字母最后出现的位置下标
        // 遍历数组，得到字符串s中每个字母最后出现的下标
        for (int i = 0; i < len; i++) {
            last[s.charAt(i) - 'a'] = i;
        }

        int start = 0, end = 0;
        for (int i = 0; i < len; i++) {
            // 每次更新当前字母最后出现的位置
            end = Math.max(end, last[s.charAt(i) - 'a']);
            if (i == end) {
                // 如果当前位置是此字母出现的最后位置（且之前遍历的字母最后位置也在此字母之前）
                res.add(end - start + 1);
                start = end + 1;
            }
        }
        return res;
    }
}
