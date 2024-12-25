package leetcode.editor.cn.test.binarysearch;

import java.util.Arrays;

/**
 * 数对 (a,b) 由整数 a 和 b 组成，其数对距离定义为 a 和 b 的绝对差值。
 * 给你一个整数数组 nums 和一个整数 k ，数对由 nums[i] 和 nums[j] 组成且满足 0 <= i < j < nums.length 。返回 所有数对距离中 第 k 小的数对距离。
 */
public class P719SmallestDistancePair {

    public static void main(String[] args) {
        P719SmallestDistancePair sdp = new P719SmallestDistancePair();
        int[] nums = new int[]{1,6,1};
        int res = sdp.smallestDistancePair(nums, 3);
        System.out.println(res);

    }

    /**
     * 寻找第k小的数对距离
     * @param nums 数组
     * @param k 第k小
     * @return 第k小的数对距离
     */
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        // 先对数组进行排序
        int n = nums.length;
        int left = 0, right = nums[n-1] - nums[0];
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                int i = binarySearch(nums, j, nums[j] - mid);
                // i为大于等于nums[j]-mid的最小数，则大于i的数，均满足大于等于nums[j]-mid;即 满足 nums[j]-nums[i]<=mid
                cnt += j - i;   // 累计距离小于mid的数对数量
            }
            if (cnt >= k) {
                // 则mid不会是第k小的数对距离，因为比mid距离小的数对数量大于等于k，mid顶多算第k+1小，故
                right = mid - 1;
            } else {
                // 比mid距离小的数对数量小于k，则第k小的数对距离在mid右边
                left = mid + 1;
            }
        }
        return left;    // 最终第k小的数对距离，在left右边，在right左边，此刻循环已终止说明left>right，故直接返回left符合要求
    }

    /**
     * 寻找大于等于target的最小元素
     * @param nums 数组
     * @param end 右边界
     * @param target 目标值
     * @return 大于等于target的最小元素
     */
    public int binarySearch(int[] nums, int end, int target) {
        int left = 0, right = end;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
