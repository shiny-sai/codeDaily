package leetcode.editor.cn.hot100;

import java.util.Arrays;

/**
 * Author: 曹赛
 * Date: 2025/3/5
 * Description:给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 */
public class P416CanPartition {

    public static void main(String[] args) {
        P416CanPartition canPartition = new P416CanPartition();
        int[] nums = new int[]{1,2,3,5};
        boolean res = canPartition.canPartition(nums);
        System.out.println(res);
    }

    /**
     * 返回是否可以将数组分割为两个子集，使两个子集和相等
     * @param nums 数组
     * @return true/false
     */
    public boolean canPartition(int[] nums) {

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        // 如果和为奇数，则肯定不能分为两个相等的子集
        if (sum % 2 == 1) return false;

        int target = sum / 2;
        // dp[i]表示 数组中是否存在子集的和等于i
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;   // 空集
        for (int num : nums) {
            for (int j = target; j >= num; j--) {
                dp[j] = dp[j] | dp[j - num];
            }
        }
        return dp[target];
    }
}
