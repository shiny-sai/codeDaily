package leetcode.editor.cn.test.slidewindow;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 ""
 */
public class P76MinimumWindowSubstring {

    // Test
    public static void main(String[] args) {
        P76MinimumWindowSubstring mws = new P76MinimumWindowSubstring();
        String s = "a";
        String t = "aa";
        String res = mws.minWindow(s, t);
        System.out.println(res);
    }

    /**
     * 返回 s 中涵盖 t 所有字符的最小子串
     * @param s 字符串1
     * @param t 要覆盖的目标子串
     * @return 最小子串
     */
    public String minWindow(String s, String t) {

        // 创建两个哈希表 分别存储s和t的元素组成
        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();

        for (char e : t.toCharArray()) {
            tMap.put(e, tMap.getOrDefault(e, 0) + 1);
        }
        // slowIndex 为滑动窗口左
        int slowIndex = 0, fastIndex = 0;
        int len = s.length();
        int ans = s.toCharArray().length + 1;
        String res = "";
        while (fastIndex < len) {
            if (!check(sMap, tMap)) {
                // 如果滑动窗口未包含t的所有字符，则fastIndex继续右移，使窗口中包含t的所有字符
                if (tMap.containsKey(s.charAt(fastIndex))) {
                    // 如果不加这个if判断会超时，因为不是每个字母都有必要关注的，只有t中的字符需要关注
                    sMap.put(s.charAt(fastIndex), sMap.getOrDefault(s.charAt(fastIndex), 0) + 1);
                }
                fastIndex++;
            }
            while (check(sMap, tMap) && slowIndex <= fastIndex) {
                // ans记录最小滑动窗口的长度
                if (fastIndex - slowIndex < ans) {
                    ans = fastIndex - slowIndex;
                    res = s.substring(slowIndex, fastIndex);
                }
                // 如果滑动窗口中包含了t的所有字符，slowIndex向右移动查看包含t字符串的最小的滑动窗口
                if (tMap.containsKey(s.charAt(slowIndex))) {
                    sMap.put(s.charAt(slowIndex), sMap.get(s.charAt(slowIndex))-1);
                }
                slowIndex++;
            }

        }
        return res;
    }

    /**
     * 比较两个哈希表的键值对，查看s中是否已经覆盖了t的所有字符，且数量也覆盖
     * @param sMap s字符串对应的sMap
     * @param tMap t字符串对于的tMap
     * @return
     */
    public boolean check(Map<Character, Integer> sMap, Map<Character, Integer> tMap) {
        for (Character key : tMap.keySet()) {
            if (tMap.get(key) > sMap.getOrDefault(key, 0)) {
                return false;
            }
        }
        return true;
    }
}

