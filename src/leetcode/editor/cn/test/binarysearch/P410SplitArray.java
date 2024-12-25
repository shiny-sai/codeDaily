package leetcode.editor.cn.test.binarysearch;

import java.util.Arrays;

/**
 * 给定一个非负整数数组 nums 和一个整数 k ，你需要将这个数组分成 k 个非空的连续子数组，使得这 k 个子数组各自和的最大值 最小。
 * 返回分割后最小的和的最大值。
 * 子数组 是数组中连续的部份。
 */
public class P410SplitArray {

    public static void main(String[] args) {
        P410SplitArray sa = new P410SplitArray();
        int[] nums = new int[]{2,16,14,15};
        int res = sa.splitArray(nums, 2);
        System.out.println(res);
    }

    public int splitArray(int[] nums, int k) {
        int n = nums.length;
        int left = 0, right = 0;
        for (int num : nums) {
            right += num;
            if (left < num) {
                left = num;
            }
        }
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int cnt = 1, sum = 0;   // cnt初始值为1，因为起手就是一个子分组
            for (int j = 0; j < n; j++) {
                if (sum + nums[j] > mid) {
                    // 若前一段+当前大于mid，说明前一段满足子区间要求：子数组的最大和 小于等于mid；则划分新的区间
                    sum = nums[j];
                    cnt++;
                } else {
                    sum += nums[j]; // 子数组和不够mid就继续加
                }
            }
            if (cnt <= k) {
                // 说明mid选大了
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
