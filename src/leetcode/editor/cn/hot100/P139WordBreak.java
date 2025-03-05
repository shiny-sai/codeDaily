package leetcode.editor.cn.hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: 曹赛
 * Date: 2025/3/5
 * Description:给你一个字符串 s 和一个字符串列表 wordDict 作为字典。如果可以利用字典中出现的一个或多个单词拼接出 s 则返回 true。
 * 注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
 */
public class P139WordBreak {
    public static void main(String[] args) {
        P139WordBreak wordBreak = new P139WordBreak();
        String s = "applepenapple";
        String[] strs = new String[]{"apple","pen"};
        List<String> wordDict = new ArrayList<>();
        for (String str : strs) {
            wordDict.add(str);
        }

        boolean res = wordBreak.wordBreak(s, wordDict);
        System.out.println(res);
    }

    /**
     * (动态规划)返回s是否可以分割为若干个单词（单词均存在与wordDict中）
     * @param s 字符串
     * @param wordDict 字典
     * @return
     */
    public boolean wordBreak(String s, List<String> wordDict) {

        // 定义dp数组，dp[i]表示0～i区间的字符子串是否可以被分为多个字典中的单词
        boolean[] dp = new boolean[s.length()+1];
        // 遍历s，得出dp
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            // 内层循环查看0～i是否可以分割成j～i和dp[j] 这样好判断
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
