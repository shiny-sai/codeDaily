package leetcode.editor.cn.hot100;

import java.util.*;

/**
 * 给定两个字符串 s 和 p，找到 s 中所有 p的异位词的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 */
public class P438FindAnagrams {

    public static void main(String[] args) {
        String s = "aaabb";
        String p = "bb";
        P438FindAnagrams fa = new P438FindAnagrams();
        List<Integer> res = fa.findAnagrams(s, p);
        System.out.println(Arrays.toString(res.toArray()));
    }


    /**
     * 返回s中包含的p的字母异位词的起始索引
     * @param s 字符串
     * @param p 异位词目标字符串
     * @return List<Integer>
     */
    public List<Integer> findAnagrams(String s, String p) {

        Map<Character, Integer> pCount = new HashMap<>();
        char[] arr = p.toCharArray();
        int windowSize = arr.length;    // 滑动窗口大小最大值
        for (char c : arr) {
            pCount.put(c, pCount.getOrDefault(c, 0)+1);
        }

        Map<Character, Integer> windowCount = new HashMap<>();

        int n = s.length();
        List<Integer> list = new ArrayList<>();
        int left = 0;
        for (int right = 0; right < n; right++) {
            if (right - left + 1 > windowSize) {
                // 滑动窗口大小超了，左边界右移，leftChar要被移除
                char leftChar = s.charAt(left);
                if (windowCount.get(leftChar) > 1) {
                    windowCount.put(leftChar, windowCount.get(leftChar) - 1);
                } else {
                    windowCount.remove(leftChar);
                }
                left++;
            }
            windowCount.put(s.charAt(right), windowCount.getOrDefault(s.charAt(right), 0) + 1);
            if (windowCount.size() == pCount.size() && windowCount.equals(pCount)) {
                list.add(left);
            }
        }
        return list;
    }
}
