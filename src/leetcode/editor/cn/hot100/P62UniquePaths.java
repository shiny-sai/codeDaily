package leetcode.editor.cn.hot100;

/**
 * Author: 曹赛
 * Date: 2025/3/6
 * Description:一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 * 问总共有多少条不同的路径？
 */
public class P62UniquePaths {

    public static void main(String[] args) {

    }

    public int uniquePaths(int m, int n) {
        // dp[i][j]表示从左上角走到（i,j）有多少种走法
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }

        // 根据第一行和第一列的走法只有1，得出其他地方的路径条数
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i][j-1] + dp[i-1][j];
            }
        }
        return dp[m-1][n-1];
    }
}
