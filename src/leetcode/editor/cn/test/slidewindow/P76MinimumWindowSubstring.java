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
        String s = "abababbaa";
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
        if (s.length() < t.length()) {
            return "";
        }
        int slowIndex = 0, fastIndex = 0;

        return "";

    }

    public boolean isContain(String s, char a) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == a) {
                return true;
            }
        }
        return false;
    }
}

