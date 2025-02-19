package leetcode.editor.cn.hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Author: 曹赛
 * Date: 2025/2/19
 * Description:给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是回文串返回 s 所有可能的分割方案。
 */
public class P131Partition {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        P131Partition partition = new P131Partition();
        while (in.hasNext()) {
            String param = in.next();
            List<List<String>> res = partition.partition(param);
            System.out.println(Arrays.toString(res.toArray()));
        }

    }


    public List<List<String>> partition(String s) {
        // 预处理DP，使后续查询是否回文子串的时间复杂度为O(1)
        // 1。长度 1 的字符串：必定是回文，例如 "a", "b", "c"。
        // 长度 2 的字符串：如果 s[i] == s[j]，就是回文，例如 "aa"。
        // 长度 3 及以上：如果 s[i] == s[j] 且 dp[i+1][j-1] == true，则 s[i:j] 也是回文
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        for (int right = 0; right < n; right++) {
            for (int left = 0; left <= right; left++) {
                if (s.charAt(right) == s.charAt(left) && (right - left <= 2 || dp[left+1][right-1])) {
                    dp[left][right] = true;
                }
            }
        }

        List<List<String>> res = new ArrayList<>();
        backtrack(res, s, 0, new ArrayList<String>(), dp);
        return res;
    }

    public void backtrack(List<List<String>> res, String s, int start, List<String> path, boolean[][] dp) {
        // 终止条件
        if (start == s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int end = start; end < s.length(); end++) {
            // 如果s[i:j]为回文子串，再往下分割
            if (dp[start][end]) {
                path.add(s.substring(start, end+1));
                backtrack(res, s, end+1, path, dp);
                path.remove(path.size()-1);
            }
        }
    }
}
