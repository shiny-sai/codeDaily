package leetcode.editor.cn.test.binarysearch;

import java.util.Arrays;

/**
 * 给定一个包含 n + 1 个整数的数组 nums ，其数字都在 [1, n] 范围内（包括 1 和 n），可知至少存在一个重复的整数。
 * 假设 nums 只有 一个重复的整数 ，返回 这个重复的数 。
 * 你设计的解决方案必须 不修改 数组 nums 且只用常量级 O(1) 的额外空间。
 */
public class P287FindDuplicate {

    public static void main(String[] args) {
        P287FindDuplicate fd = new P287FindDuplicate();
        int[] nums = new int[]{2,2,2,3};
        int res = fd.findDuplicate(nums);
        System.out.println(res);
    }

    /**
     * 寻找重复元素(直接排序)
     * @param nums 数组
     * @return 返回重复的那个数
     */
    public int findDuplicate1(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i-1]) {
                return nums[i];
            }
        }
        return -1;
    }

    public int findDuplicate(int[] nums) {
        int n = nums.length;
        int l = 0, r = n - 1;
        int ans = -1;
        while (l <= r) {
            int cnt = 0;
            int mid = l + (r - l)/2;
            for (int i = 0; i < n; i++) {
                if(nums[i] <= nums[mid]) {
                    cnt++;
                }
            }
            if (cnt <= mid) {
                l = mid + 1;
            } else {
                r = mid - 1;
                ans = mid;
            }
        }
        return ans;
    }
}
