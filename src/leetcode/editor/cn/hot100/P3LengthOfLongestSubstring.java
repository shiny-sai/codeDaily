package leetcode.editor.cn.hot100;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的最长子串的长度。
 */
public class P3LengthOfLongestSubstring {

    public static void main(String[] args) {
        P3LengthOfLongestSubstring lols = new P3LengthOfLongestSubstring();
        String s = " ";
        int res = lols.lengthOfLongestSubstring(s);
        System.out.println(res);
    }

    /**
     * 计算无重复字符最长子串长度
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        // 哈希表存储已经遍历过的字符
        Map<Character, Integer> map = new HashMap<>();
        int ans = 0;    // 最长无重复子串的长度
        int slowIndex = 0, fastIndex = 0, n = s.length();
        while (fastIndex < n) {
            if (!map.containsKey(s.charAt(fastIndex))) {
                char fch = s.charAt(fastIndex);
                map.put(fch, map.getOrDefault(fch, 0) + 1);
                fastIndex++;
            } else {
                char sch = s.charAt(slowIndex);
                map.put(sch, map.getOrDefault(sch, 0) - 1);
                if (map.get(sch) == 0) {
                    map.remove(sch);
                }
                slowIndex++;
            }
            ans = Math.max(ans, fastIndex - slowIndex);
        }
        return ans;
    }
}
