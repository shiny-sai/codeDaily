package leetcode.editor.cn.hot100;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Author: 曹赛
 * Date: 2025/2/19
 * Description:给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0
 */
public class P121MaxProfit {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        P121MaxProfit maxProfit = new P121MaxProfit();
        while (in.hasNextLine()) {
            String[] ch = in.nextLine().split(" ");
            int n = ch.length;
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = Integer.valueOf(ch[i]);
            }
            System.out.println(maxProfit.maxProfit(nums));
        }
    }

    public int maxProfit(int[] prices) {
        int minprice = Integer.MAX_VALUE;
        int maxProfit = 0;
        int n = prices.length;
        for (int i = 0; i < n; i++) {
            if (prices[i] < minprice) {
                minprice = prices[i];
            } else if (prices[i] - minprice > maxProfit) {
                maxProfit = prices[i] - minprice;
            }
        }
        return maxProfit;
    }
}
