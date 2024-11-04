package leetcode.editor.cn.test.doublepointer;

import java.util.Arrays;

public class P283MoveZeroes {

    // Test
    public static void main(String[] args) {
        P283MoveZeroes mz = new P283MoveZeroes();
        int[] nums = new int[]{0};
        int[] tt = mz.moveZeroes(nums);
        System.out.println(Arrays.toString(tt));
    }

    /**
     * 将数组中的0移到数组末尾而不改变数组非零元素相对位置顺序
     * @param nums 数组
     * @return 改造后的数组
     */
    public int[] moveZeroes(int[] nums) {
        int len = removeElment(nums, 0);
        for (int i = len; i < nums.length; i++) {
            nums[i] = 0;
        }
        return nums;
    }
    /**
     * 移除数组中目标元素val，并返回最终数组长度
     * @param nums 数组
     * @param val 目标值
     * @return 数组长度
     */
    public int removeElment(int[] nums, int val) {
        int slowIndex = 0;
        for (int fastIndex = 0; fastIndex < nums.length; fastIndex++) {
            if (nums[fastIndex] != val) {
                nums[slowIndex] = nums[fastIndex];
                slowIndex++;
                // 这里上一步运行完，slowIndex比fastIndex先加一
            }
        }
        return slowIndex;
    }
}
