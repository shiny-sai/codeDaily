package leetcode.editor.cn.hot100;

import java.util.*;

/**
 * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 * 字母异位词 是由重新排列源单词的所有字母得到的一个新单词。
 */
public class P49GroupAnagrams {

    public static void main(String[] args) {

        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        P49GroupAnagrams ga = new P49GroupAnagrams();
        List<List<String>> res = ga.groupAnagrams(strs);
        System.out.println(Arrays.toString(res.toArray()));
    }

    /**
     * 解法一：对每个字符串排序，再作为键存入哈希表
     * @param strs 字符串数组
     * @return 分类后的列表
     */
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String key = new String(arr);
            List<String> cnt = map.getOrDefault(key, new ArrayList<String>());
            cnt.add(str);
            map.put(key, cnt);
        }
        return new ArrayList<>(map.values());
    }

    /**
     * 解法二：计数
     * @param strs 字符串数组
     * @return 分类后的数组
     */
    public List<List<String>> groupAnagrams1(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String key = new String(arr);
            List<String> cnt = map.getOrDefault(key, new ArrayList<String>());
            cnt.add(str);
            map.put(key, cnt);
        }
        return new ArrayList<>(map.values());
    }
}
