package leetcode.editor.cn.test.doublepointer;

import java.util.Arrays;

/**
 * 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
 */
public class P977SortedSquares {

    // Test
    public static void main(String[] args) {
        P977SortedSquares ss = new P977SortedSquares();
        int[] nums = new int[]{-5,-3,-2,-1};
        int[] res = ss.sortedSquares(nums);
        System.out.println(Arrays.toString(res));
    }

    /**
     * 输入一个数组，输出数组元素的平方（排序）
     * 这题的思路想到的是找到正负数分界限，然后比较分界限两边的平方数大小，谁小存到新数组，但也可以直接从两边开始比较，谁大放在最后
     * @param nums 原数组
     * @return 有序数组的平方
     */
    public int[] sortedSquares(int[] nums) {
        // 用例 [-5,-3,-2,-1] 不通过，因为slowIndex初始值赋值为0了，导致整个数组都是负数时，也是从0开始往左遍历，其实应该从nums.length-1开始往左遍历，平方数递增
        int slowIndex = nums.length-1, fastIndex = 0;
        for (; fastIndex < nums.length; fastIndex++) {
            if (nums[fastIndex] >= 0) {
                slowIndex = fastIndex - 1;
                break;
            }
        }
        int[] x = new int[nums.length];
        int count = 0;
        while (slowIndex >= 0 && fastIndex < nums.length) {
            if (Math.abs(nums[slowIndex]) < Math.abs(nums[fastIndex])) {
                x[count++] = Math.abs(nums[slowIndex]) * Math.abs(nums[slowIndex]);
                slowIndex--;
            } else {
                x[count++] = Math.abs(nums[fastIndex]) * Math.abs(nums[fastIndex]);
                fastIndex++;
            }
        }
        while (fastIndex < nums.length) {
            x[count++] = Math.abs(nums[fastIndex]) * Math.abs(nums[fastIndex]);
            fastIndex++;
        }
        while (slowIndex >= 0) {
            x[count++] = Math.abs(nums[slowIndex]) * Math.abs(nums[slowIndex]);
            slowIndex--;
        }
        return x;

    }

}
