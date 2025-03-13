package leetcode.editor.cn.hot100;

/**
 * Author: 曹赛
 * Date: 2025/3/13
 * Description:给你两个单词 word1 和 word2， 请返回将 word1 转换成 word2 所使用的最少操作数  。
 * 你可以对一个单词进行如下三种操作：
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 */
public class P72MinDistance {
    public static void main(String[] args) {


    }

    /**
     * 二维动态规划返回word1 转换成 word2 所使用的最少操作数
     * @param word1 字符串
     * @param word2 字符串
     * @return 最少操作次数
     */
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m+1][n+1];

        // 当有一个或两个空串时，返回非空串长度（即需要全删除）
        if (m*n == 0) {
            return n+m;
        }
        dp[0][0] = 0;
        for (int i = 1; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int j = 1; j <= n; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                int left = dp[i - 1][j] + 1;
                int down = dp[i][j - 1] + 1;
                int left_down = dp[i - 1][j - 1];

                if (word1.charAt(i-1) != word2.charAt(j-1)) {
                    left_down += 1;
                }
                dp[i][j] = Math.min(left_down, Math.min(left, down));
            }
        }

        return dp[m][n];
    }

}
