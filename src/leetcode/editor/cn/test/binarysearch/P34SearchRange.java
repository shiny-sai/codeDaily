package leetcode.editor.cn.test.binarysearch;

import java.util.Arrays;

/**
 * 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
 *
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 *
 * 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。
 */
public class P34SearchRange {

    // Test
    public static void main(String[] args) {
        P34SearchRange sr = new P34SearchRange();
        int[] res = sr.searchRange(new int[]{1}, 1);
        System.out.println(Arrays.toString(res));
    }

    /**
     * 查找在非递减数组中，目标元素出现的区间索引
     * @param nums 非递减数组
     * @param target 目标元素
     * @return 索引区间
     */
    public int[] searchRange(int[] nums, int target) {
        int lindex = binarySearch(nums, target, true);
        int rindex = binarySearch(nums, target, false) - 1;
        if (lindex <= rindex && rindex < nums.length && nums[lindex] == target && nums[rindex] == target) {
            return new int[]{lindex, rindex};
        }
        return new int[]{-1, -1};
        
    }

    /**
     * 改装版的二分查找
     * @param nums 数组
     * @param target 目标元素
     * @param lower 是否查找索引最小的目标元素
     * @return 索引
     */
    public int binarySearch(int[] nums, int target, boolean lower) {

        int low = 0, high = nums.length, ans = nums.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] > target || (lower && nums[mid] >= target)) {
                // 寻找第一个大于 target 的下标 || 在数组中寻找第一个大于等于 target 的下标
                high = mid;
                ans = mid;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
}
