package leetcode.editor.cn.hot100;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 */
public class P76MinWindow {

    public static void main(String[] args) {
        P76MinWindow mw = new P76MinWindow();
        String s = "ADOBECODEBANC";
        String t = "ABC";
        String res = mw.minWindow(s,t);
        System.out.println(res);
    }

    /**
     * 从s中找出包含t所有字符的最小覆盖子串
     * @param s 字符串
     * @param t 字符串
     * @return 最小覆盖子串
     */
    public String minWindow(String s, String t) {
        Map<Character, Integer> tCount = new HashMap<>();
        Map<Character, Integer> sCount = new HashMap<>();
        for (char c : t.toCharArray()) {
            tCount.put(c, tCount.getOrDefault(c, 0) + 1);
        }
        String result = "";
        int left = 0, n = s.length();
        for (int right = 0; right < n; right++) {
            char currChar = s.charAt(right);
            sCount.put(currChar, sCount.getOrDefault(currChar, 0) + 1);
            while(checkContains(sCount, tCount)) {
                if (result == "") {
                    result = s.substring(left, right + 1);
                }
                result = result.length() > (right - left + 1) ? s.substring(left, right + 1) : result;
                // 移除左边界元素
                char leftChar = s.charAt(left);
                sCount.put(leftChar, sCount.get(leftChar) - 1);
                if (sCount.get(leftChar) == 0) {
                    sCount.remove(leftChar);
                }
                left++;
            }
        }
        return result;
    }

    /**
     * 比较哈希表sCount中是否包含tCount中所有key 且 value大于等于t中value
     * @param sCount 哈希表
     * @param tCount 哈希表
     * @return true/false
     */
    public boolean checkContains(Map<Character, Integer> sCount, Map<Character, Integer> tCount) {
        for (Character key : tCount.keySet()) {
            if (sCount.getOrDefault(key, 0) < tCount.get(key)) {
                return false;
            }
        }
        return true;
    }


}
