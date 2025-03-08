package leetcode.editor.cn.hot100;

/**
 * Author: 曹赛
 * Date: 2025/3/8
 * Description:
 */
public class P64MinPathSum {

    public static void main(String[] args) {
        P64MinPathSum minPathSum = new P64MinPathSum();
        int[][] grid = new int[][]{{1,2,3},{4,5,6}};
        int res = minPathSum.minPathSum(grid);
        System.out.println(res);
    }

    /**
     * 返回最小路径和
     * @param grid 网格grid
     * @return 最小路径和
     */
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        // dp[i][j]记录(0,0) 到 (i,j)的最小路径和
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = grid[i][j];
                }else if (i == 0 && j > 0) {
                    dp[i][j] = dp[i][j-1] + grid[i][j];
                } else if (j == 0 && i > 0) {
                    dp[i][j] = dp[i-1][j] + grid[i][j];
                } else {
                    dp[i][j] = Math.min(dp[i][j-1], dp[i-1][j]) + grid[i][j];
                }
            }
        }
        return dp[m-1][n-1];
    }

}
