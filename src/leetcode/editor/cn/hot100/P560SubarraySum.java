package leetcode.editor.cn.hot100;

import java.util.HashMap;
import java.util.Map;

/**
 *给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。子数组是数组中元素的连续非空序列。
 * (此题不能用滑动窗口，滑动窗口适用于非负数)使用前缀和+哈希表
 */
public class P560SubarraySum {
    public static void main(String[] args) {
        P560SubarraySum ss = new P560SubarraySum();
        int[] nums = new int[]{-1,-1,1};
        int res = ss.subarraySum(nums, 0);
        System.out.println(res);
    }

    /**
     * 计算数组中连续非空序列和为k的个数
     * @param nums 数组
     * @param k 目标和
     * @return 连续非空序列个数
     */
    public int subarraySum(int[] nums, int k) {

        Map<Integer, Integer> prefixMap = new HashMap<>();
        prefixMap.put(0,1); // 初始化前缀和为0的
        int count = 0;
        int prefixSum = 0;
        for (int num : nums) {
            prefixSum += num;
            // 如果 prefixSum - k 存在，说明找到了前面若干个子数组和为k
            if (prefixMap.containsKey(prefixSum - k)) {
                // 记录的不应该是一次 不应该是count++
                count += prefixMap.get(prefixSum - k);
                // 累加 prefixSum - k 出现的次数
            }
            prefixMap.put(prefixSum, prefixMap.getOrDefault(prefixSum, 0) + 1);
        }
        return count;
    }
}
