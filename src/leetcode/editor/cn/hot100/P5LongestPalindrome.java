package leetcode.editor.cn.hot100;

import java.util.Scanner;

/**
 * Author: 曹赛
 * Date: 2025/2/21
 * Description:
 */
public class P5LongestPalindrome {
    public static void main(String[] args) {
        P5LongestPalindrome longestPalindrome = new P5LongestPalindrome();
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String s = in.nextLine();
            String res = longestPalindrome.longestPalindrome(s);
            System.out.println(res);
        }
    }

    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        int maxLength = 1;
        int begin = 0;
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i < n; i++) {
                int j = i + len - 1;
                if (j >= n) {
                    break;
                }
                if (s.charAt(i) != s.charAt(j)) {
                    dp[i][j] = false;
                } else {
                    // 子串长度为2 / 3 且左右边界元素相等，则一定为回文串
                    if (j - i <= 2) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i+1][j-1];
                    }
                }

                if (dp[i][j] == true && maxLength < (j-i+1)) {
                    maxLength = j-i+1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin+maxLength);
    }

}
