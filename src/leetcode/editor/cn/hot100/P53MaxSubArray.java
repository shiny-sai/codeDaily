package leetcode.editor.cn.hot100;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。子数组是数组中的一个连续部分。
 */
public class P53MaxSubArray {

    public static void main(String[] args) {
        P53MaxSubArray maxSubArray = new P53MaxSubArray();
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        int res = maxSubArray.maxSubArray1(nums);
        System.out.println(res);
    }

    /**
     * 返回最大和的连续子数组的和(使用前缀和)
     * @param nums 数组
     * @return 连续子数组的最大和
     */
    public int maxSubArray(int[] nums) {
        int prefixSum = 0;
        int minPrefixSum = 0; // 最小前缀和
        int maxSum = Integer.MIN_VALUE; // 最大子数组和

        for (int num : nums) {
            prefixSum += num; // 累加当前值，更新前缀和
            maxSum = Math.max(maxSum, prefixSum - minPrefixSum); // 更新最大子数组和
            minPrefixSum = Math.min(minPrefixSum, prefixSum); // 更新最小前缀和
        }

        return maxSum;
    }

    /**
     * 返回最大和的连续子数组的和(使用动态规划)
     * @param nums 数组
     * @return 连续子数组的最大和
     */
    public int maxSubArray1(int[] nums) {
        int prefixSum = 0;
        int maxSum = nums[0]; // 最大子数组和
        for (int num : nums) {
            prefixSum = Math.max(prefixSum + num, num);
            maxSum = Math.max(maxSum, prefixSum);
        }
        return maxSum;
    }
}
