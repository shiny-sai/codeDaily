package leetcode.editor.cn.hot100;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.util.Scanner;

/**
 * Author: 曹赛
 * Date: 2025/2/21
 * Description:
 */
public class P279NumSquares {

    public static void main(String[] args) {
        P279NumSquares numSquares = new P279NumSquares();
        Scanner in = new Scanner(System.in);

        while (in.hasNextInt()) {
            int n = in.nextInt();
            int res = numSquares.numSquares(n);
            System.out.println(res);
        }
    }

    public int numSquares(int n) {

        int[] dp = new int[n+1];
        for (int i = 1; i <= n; i++) {
            int sqrt = (int) Math.sqrt(i);
            int minCount = Integer.MAX_VALUE;
            for (int j = sqrt; j >= 1; j--) {
                minCount = Math.min(minCount, dp[i - j*j]);
            }
            dp[i] = 1 + minCount;
        }
        return dp[n];
    }
}
