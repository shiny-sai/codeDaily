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
        int slowIndex = 0;
        int minLength = Integer.MAX_VALUE;
        Map<Character, Integer> st = new HashMap<>();
        for (int fastIndex = 0; fastIndex < s.length(); fastIndex++) {
            if (isContain(t, s.charAt(fastIndex))) {
                if (st.size() == 0) {
                    // 前面那些t不包含的直接跳过
                    slowIndex = fastIndex;
                }
                st.put(s.charAt(fastIndex), st.getOrDefault(s.charAt(fastIndex), 0) + 1);
                if (s.charAt(fastIndex) == s.charAt(slowIndex)) {
                    while (slowIndex < fastIndex) {
                        if (!isContain(t, s.charAt(slowIndex))) {
                            slowIndex++;
                        } else if (st.get(s.charAt(slowIndex)) > 1) {
                            st.put(s.charAt(slowIndex), st.get(s.charAt(slowIndex)) - 1);
                            slowIndex++;
                        } else {
                            break;
                        }
                    }
                }
            }

            if (st.size() == t.length()) {
                // 说明完全覆盖到了t这个字符串
                minLength = Math.min(minLength, fastIndex - slowIndex + 1);
            }
        }

        return s.substring(slowIndex, slowIndex+minLength);
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

