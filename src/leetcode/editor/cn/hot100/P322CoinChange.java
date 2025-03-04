package leetcode.editor.cn.hot100;

import java.util.Arrays;

/**
 * Author: 曹赛
 * Date: 2025/3/4
 * Description:给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
 * 你可以认为每种硬币的数量是无限的。
 */
public class P322CoinChange {

    public static void main(String[] args) {
        P322CoinChange coinChange = new P322CoinChange();
        int[] coins = new int[]{1, 2, 5};
        int amount = 11;
        int res = coinChange.coinChange(coins, amount);
        System.out.println(res);
    }

    /**
     * (动态规划)返回用指定面额的硬币兑换对应钱数，最少要几张
     * @param coins 指定面额的硬币
     * @param amount 钱数
     * @return 最少硬币数量
     */
    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        // 存放兑换下标数值的钱，最少需要多少个硬币
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        // 外层循环是dp，为了计算dp[]
        for (int i = 1; i <= amount ; i++) {
            // 内层循环遍历coins数组
            for (int j = 0; j < coins.length; j++) {
                // 只有兑换的钱币数量大于等于兑换硬币的大小，才可以兑换
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i-coins[j]] + 1);
                }
            }
        }
        // 如果兑换amount数量的钱，需要的硬币个数大于amount，显然是初始化的amount+1，无法兑换返回-1；否则返回dp[amount]，表示最小硬币的数量
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
